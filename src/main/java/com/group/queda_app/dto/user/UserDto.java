package com.group.queda_app.dto.user;

import com.group.queda_app.domain.user.User;
import com.group.queda_app.dto.user.reponse.UserReponse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long userNum;
    private String userId;
    private String password;
    private String userName;
    private String address;
    private String nickname;
    private String email;
    private Boolean isAdmin;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public static UserDto touserDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setUserNum(user.getUserNum());
        userDto.setUserId(user.getUserId());
        userDto.setPassword(user.getPassword());
        userDto.setUserName(user.getUser_name());
        userDto.setAddress(user.getAddress());
        userDto.setNickname(user.getNickname());
        userDto.setEmail(user.getEmail());
        userDto.setIsAdmin(user.is_admin());
        userDto.setDateCreated(user.getDateCreated());
        return userDto;
    }
}