package com.group.queda_app.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer userNum;
    private String userId;
    private String password;
    private String userName;
    private String address;
    private String nickname;
    private String email;
    private Boolean isAdmin = false;
    private LocalDateTime dateCreated = LocalDateTime.now();

}