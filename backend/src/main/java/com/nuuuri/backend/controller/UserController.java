package com.nuuuri.backend.controller;

import com.nuuuri.backend.data.entity.User;
import com.nuuuri.backend.dto.UserDTO;
import com.nuuuri.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

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
    public ResponseEntity getUser(@PathVariable String userId) {

        try {
            User user = userService.getUser(userId);
            return ResponseEntity.ok()
                    .body(new UserDTO.Response(user));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("유저 정보 조회 실패");
        }
    }

    @PutMapping(value = "/{userId}")
    public void updateUser(@PathVariable String userId,
                           @RequestBody UserDTO.Request request) {

    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable String userId) {

    }
}
