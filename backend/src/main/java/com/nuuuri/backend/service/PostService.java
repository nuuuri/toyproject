package com.nuuuri.backend.service;

import com.nuuuri.backend.data.entity.Post;
import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.data.repository.PostRepository;
import com.nuuuri.backend.data.repository.UserRepository;
import com.nuuuri.backend.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new PostDTO(post);
    }

    @Transactional(readOnly = true)
    public List<PostDTO> getAllDesc() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
    }
    
    @Transactional
    public void createPost(String userId, String title, String content) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        Post post = new Post(user, title, content);

        postRepository.save(post);
    }
}
