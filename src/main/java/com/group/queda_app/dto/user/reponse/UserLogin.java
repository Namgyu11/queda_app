package com.group.queda_app.dto.user.reponse;

import com.group.queda_app.domain.user.User;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin { // UserLogin DTO Entity객체 교환 역할
    private Long userNum;
    private String userId;
    private String password;



    public static UserLogin toUserLogin(User user){
        UserLogin userLogin = new UserLogin();
        userLogin.setUserNum(user.getUserNum());
        userLogin.setUserId(user.getUserId());
        userLogin.setPassword(user.getPassword());
        return  userLogin;
    }
}
