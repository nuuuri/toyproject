package com.nuuuri.backend.controller;

import com.nuuuri.backend.dto.PostDTO;
import com.nuuuri.backend.service.PostService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping(value = "/{id}")
    public PostDTO getPost(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping()
    public List<PostDTO> getAllPost() {
        return postService.getAllDesc();
    }

    @PostMapping
    public void createPost(@RequestBody CreatePostRequest requestData) {
        try {
            postService.createPost(requestData.getUserId(), requestData.getTitle(), requestData.getContent());
        } catch (Exception err) {

        }
    }
}

@Data
class CreatePostRequest {
    private String userId;
    private String title;
    private String content;
}