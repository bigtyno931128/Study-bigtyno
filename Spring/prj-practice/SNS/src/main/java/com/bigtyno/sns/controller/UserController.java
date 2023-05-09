package com.bigtyno.sns.controller;

import com.bigtyno.sns.controller.reponse.UserJoinResponse;
import com.bigtyno.sns.controller.reponse.UserLoginResponse;
import com.bigtyno.sns.controller.request.Response;
import com.bigtyno.sns.controller.request.UserJoinRequest;
import com.bigtyno.sns.controller.request.UserLoginRequest;
import com.bigtyno.sns.model.User;
import com.bigtyno.sns.service.UserService;
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
        return Response.success(UserJoinResponse.fromUser(userService.join(request.getUserName(), request.getPassword())));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getUserName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }
}
