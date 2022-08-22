package com.jisu.controller;

import com.jisu.controller.request.UserJoinRequest;
import com.jisu.controller.response.Response;
import com.jisu.controller.response.UserJoinResponse;
import com.jisu.model.User;
import com.jisu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        User user = userService.join(request.getUserName(), request.getPassword());
        System.out.println("user: " + user);
        return Response.success(UserJoinResponse.fromUser(user));
    }
}
