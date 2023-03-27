package com.group.queda_app.dto.user.reponse;

import com.group.queda_app.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserReponse {

    private Long userNum;
    private String userId;
    private String password;
    private String userName;
    private String address;
    private String nickname;
    private String email;
    private boolean isAdmin;
    private LocalDateTime dateCreated;



    // Mapstruct 사용하기
    public static UserReponse toUserReponce(User user){
        UserReponse userReponse = new UserReponse();
        userReponse.setUserNum(user.getUserNum());
        userReponse.setUserId(user.getUserId());
        userReponse.setPassword(user.getPassword());
        userReponse.setUserName(user.getUser_name());
        userReponse.setAddress(user.getAddress());
        userReponse.setNickname(user.getNickname());
        userReponse.setEmail(user.getEmail());
        userReponse.setAdmin(user.is_admin());
        userReponse.setDateCreated(user.getDateCreated());
        return userReponse;
    }


}
