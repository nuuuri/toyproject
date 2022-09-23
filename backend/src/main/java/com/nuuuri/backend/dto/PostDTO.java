package com.nuuuri.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime date;
    private int look;
}
