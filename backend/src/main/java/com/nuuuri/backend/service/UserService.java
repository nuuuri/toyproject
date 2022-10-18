package com.nuuuri.backend.service;

import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.data.repository.UserRepository;
import com.nuuuri.backend.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 생성해줌
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDTO getUser(String userId) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));

        return new UserDTO(user);
    }

    @Transactional
    public void createUser(UserDTO userDTO) {
        userRepository.save(userDTO.toEntity());
    }
}
