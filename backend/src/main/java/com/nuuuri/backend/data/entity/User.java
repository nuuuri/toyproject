package com.nuuuri.backend.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_uuid", unique = true, nullable = false)
    private Long id;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(length = 20, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @Builder
    public User(String name, String userId, String password) {
        this.name = name;
        this.userId = userId;
        this.password = password;
    }
}
