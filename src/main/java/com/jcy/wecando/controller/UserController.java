package com.jcy.wecando.controller;

import com.jcy.wecando.payload.request.SignUpRequest;
import com.jcy.wecando.payload.response.UserResponse;
import com.jcy.wecando.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserResponse getMyInfo(@RequestHeader("Authorization") String token) {
        return userService.getMyInfo(token);
    }

    @PostMapping
    public void signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest);
    }

    @PutMapping("/comment")
    public void updateIsComment(@RequestHeader("Authorization") String token,
                                @RequestParam Boolean isComment) {
        userService.updateIsNotificationComment(token, isComment);
    }
}