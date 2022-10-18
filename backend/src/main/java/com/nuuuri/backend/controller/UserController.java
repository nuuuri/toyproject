package com.nuuuri.backend.controller;

import com.nuuuri.backend.dto.UserDTO;
import com.nuuuri.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping()
    public UserDTO getUser(@RequestParam String userId) {
        return userService.getUser(userId);
    }

    @PostMapping()
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }
}
