package com.nuuuri.backend.controller;

import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.dto.PostDTO;
import com.nuuuri.backend.service.PostService;
import com.nuuuri.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final UserService userService;

    @PostMapping()
    //@ApiOperation(value = "게시글 작성", notes = "게시글을 작성하는 API입니다.")
    public Long createPost(@RequestBody PostDTO.Request postRequestDTO) {
        User user = userService.getUser(postRequestDTO.getUserId());

        return postService
                .createPost(user, postRequestDTO.getTitle(), postRequestDTO.getContent());
    }
}
