package com.nuuuri.backend.dto;

import com.nuuuri.backend.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String userId;
    private String password;

    @Builder
    public UserDTO(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .userId(userId)
                .password(password)
                .build();
    }

    public UserDTO(User entity) {
        this.name = entity.getName();
        this.userId = entity.getUserId();
        this.password = entity.getPassword();
    }
}
