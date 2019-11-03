package com.haky.webservice.web;

import com.haky.webservice.domain.posts.PostsRepository;
import com.haky.webservice.dto.posts.PostsSaveRequestDto;
import com.haky.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;
    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "Hi haky";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
//        postsRepository.save(dto.toEntity());
        return postsService.save(dto);
    }
}
