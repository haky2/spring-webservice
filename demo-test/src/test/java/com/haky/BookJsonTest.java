package com.haky;

import com.haky.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@JsonTest
public class BookJsonTest {

    @Autowired
    private JacksonTester<Book> json;

    @Test
    public void json_테스트() throws Exception {
        Book book = Book.builder().title("테스트").build();
        String content = "{\"title\":\"테스트\"}";

        // 문자열을 json으로 변환시켜서 title이 가튼ㅇ지 확인
        assertThat(this.json.parseObject(content).getTitle()).isEqualTo(book.getTitle());
        // 문자열을 json으로 변환시켜서 publishedAt이 null인지 확인
        assertThat(this.json.parseObject(content).getPublishedAt()).isNull();
        // 해당 경로의 팡리의 내용과 일치하는지 확인
        assertThat(this.json.write(book)).isEqualToJson("/test.json");
        // title 값이 있는지 확인
        assertThat(this.json.write(book)).hasJsonPathStringValue("title");
        // title 값이 일치하는지 확인
        assertThat(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트");
    }
}
