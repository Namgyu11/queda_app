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


    @PostMapping("user/login") // 오류 해결 @ModelAtrribute 함부로 쓰지 말것!!!!!!!!!!!!!!!! 아오!!
    public String login(@RequestBody UserDto userDto, HttpSession session){
        UserDto logintResult  = userService.login(userDto);

        if(logintResult != null) {
            session.setAttribute("loginid", userDto.getUserId());
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
    public void userLogin(@ModelAttribute UserDto userDto){
        userService.userLogin(userDto);
    }


}
