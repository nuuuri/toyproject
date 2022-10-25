package com.nuuuri.backend.dto;

import com.nuuuri.backend.data.entity.Post;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

public class PostDTO {

    @Data
    @AllArgsConstructor
    @ApiModel(value = "postRequestDTO")
    public static class Request {
        private String userId;
        private String title;
        private String content;
    }

    @Data
    @ApiModel(value = "postResponseDTO")
    public static class Response {
        private String userId;
        private String title;
        private String content;
        private int look;
        private LocalDateTime created;
        private LocalDateTime modified;

        public Response(Post entity) {
            this.userId = entity.getUser().getUserId();
            this.title = entity.getTitle();
            this.content = entity.getContent();
            this.look = entity.getLook();
            this.created = entity.getCreated();
            this.modified = entity.getModified();
        }
    }
}
