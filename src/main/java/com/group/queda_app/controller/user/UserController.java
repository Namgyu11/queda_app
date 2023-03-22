package com.group.queda_app.controller.user;

import com.group.queda_app.dto.user.UserDto;
import com.group.queda_app.dto.user.reponse.UserLogin;
import com.group.queda_app.dto.user.reponse.UserReponse;
import com.group.queda_app.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("user/login")
    public String login(@ModelAttribute UserReponse userReponse, HttpSession session){
        UserReponse logintResult  = userService.login(userReponse);

        if(logintResult != null) {
            session.setAttribute("loginid", userReponse.getUserId());
            // login 성공
            System.out.println("로그인성공");

            return "main";
        } else {
            // login 실패
            System.out.println("로그인실패");

            return "login";
        }

    }

    @PostMapping("user/11")
    public void userLogin(@RequestBody UserReponse userReponse){
        userService.userLogin(userReponse);
    }


}
