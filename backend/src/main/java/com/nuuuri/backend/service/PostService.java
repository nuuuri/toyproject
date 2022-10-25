package com.nuuuri.backend.service;

import com.nuuuri.backend.data.entity.Post;
import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.data.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long createPost(User user, String title, String content) {
        Post post = Post.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();

        return postRepository.save(post).getId();
    }
}
