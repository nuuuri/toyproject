package com.nuuuri.backend.service;

import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    @Transactional(readOnly = true)
    public User getUser(String userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("해당 유저가 존재하지 않습니다."));
    }

    @Transactional
    public void updateUser(String userId, String name, String password) {

    }

    @Transactional
    public void deleteUser(String userId) {

    }
}
