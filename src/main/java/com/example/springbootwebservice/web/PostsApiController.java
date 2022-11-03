package com.example.springbootwebservice.web;

import com.example.springbootwebservice.web.dto.PostsListResponseDto;
import com.example.springbootwebservice.web.dto.PostsResponseDto;
import com.example.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.example.springbootwebservice.web.dto.PostsUpdateRequestDto;
import com.example.springbootwebservice.web.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    PostsUpdateRequestDto requestDto) {

        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {

        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }


    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postService.findAllDesc();
    }
}
