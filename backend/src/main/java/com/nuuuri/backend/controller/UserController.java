package com.nuuuri.backend.controller;

import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.dto.UserDTO;
import com.nuuuri.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public Long createUser(@RequestBody UserDTO.Request userRequestDTO) {

        return userService.createUser(userRequestDTO.toEntity());
    }

    @GetMapping(value = "/{userId}")
    public UserDTO.Response getUser(@PathVariable String userId) {
        User user = userService.getUser(userId);

        return new UserDTO.Response(user);
    }

    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable String userId,
                           @RequestBody UserDTO.Request request) {

    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable String userId) {

    }
}
