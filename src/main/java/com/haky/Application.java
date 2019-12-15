package com.haky;

import com.haky.domain.Board;
import com.haky.domain.User;
import com.haky.domain.enums.BoardType;
import com.haky.repository.BoardRepository;
import com.haky.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // CommandLineRunner 애플리케이션 구동 후 특정 코드 실행시키고 싶을 때 구현하는 인터페이스
    @Bean
    public CommandLineRunner runner(UserRepository userRepository, BoardRepository boardRepository) throws Exception {
        return (args) -> {
            User user = userRepository.save(User.builder()
                    .name("haky")
                    .password("test")
                    .email("haky@gmail.com")
                    .createdDate(LocalDateTime.now())
                    .build());

            IntStream.rangeClosed(1, 200).forEach(index ->
                    boardRepository.save(Board.builder()
                            .title("게시글" + index)
                            .subTitle("순서" + index)
                            .content("콘텐츠")
                            .boardType(BoardType.free)
                            .createdDate(LocalDateTime.now())
                            .updatedDate(LocalDateTime.now())
                            .user(user)
                            .build())
            );
        };
    }
}
