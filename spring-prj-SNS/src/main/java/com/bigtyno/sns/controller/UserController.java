package com.bigtyno.sns.controller;

import com.bigtyno.sns.controller.reponse.AlarmResponse;
import com.bigtyno.sns.controller.reponse.UserJoinResponse;
import com.bigtyno.sns.controller.reponse.UserLoginResponse;
import com.bigtyno.sns.controller.request.Response;
import com.bigtyno.sns.controller.request.UserJoinRequest;
import com.bigtyno.sns.controller.request.UserLoginRequest;
import com.bigtyno.sns.model.User;
import com.bigtyno.sns.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
        return Response.success(UserJoinResponse.fromUser(userService.join(request.getName(), request.getPassword())));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        String token = userService.login(request.getName(), request.getPassword());
        return Response.success(new UserLoginResponse(token));
    }

    @GetMapping("/alarm")
    public Response<Page<AlarmResponse>> alarm(Pageable pageable, Authentication authentication) {
        return Response.success(userService.alarmList(authentication.getName(),pageable).map(AlarmResponse::fromAlarm));
    }
}
