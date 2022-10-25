package com.nuuuri.backend.dto;

import com.nuuuri.backend.data.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class UserDTO {

    @Data
    @AllArgsConstructor
    @ApiModel(value = "userRequestDTO")
    public static class Request {
        private String name;
        private String userId;
        private String password;

        @Builder
        public User toEntity() {
            return User.builder()
                    .name(name)
                    .userId(userId)
                    .password(password)
                    .build();
        }
    }

    @Data
    @ApiModel(value = "userResponseDTO")
    public static class Response {
        private String name;
        private String userId;

        public Response(User entity) {
            this.name = entity.getName();
            this.userId = entity.getUserId();
        }
    }
}
