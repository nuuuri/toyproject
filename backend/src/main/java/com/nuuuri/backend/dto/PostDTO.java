package com.nuuuri.backend.dto;

import com.nuuuri.backend.data.entity.Post;
import com.nuuuri.backend.data.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private User user;
    private String title;
    private String content;
    private int look;

    @Builder
    public PostDTO(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.look = 0;
    }

    public PostDTO(Post entity) {
        this.user = entity.getUser();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.look = entity.getLook();
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
