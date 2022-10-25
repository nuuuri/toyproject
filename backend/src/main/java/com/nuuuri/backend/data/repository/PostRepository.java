package com.nuuuri.backend.data.repository;

import com.nuuuri.backend.data.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Optional<Post>> findAllByOrderByIdDesc();
}
