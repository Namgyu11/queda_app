package com.group.queda_app.service.user;

import com.group.queda_app.domain.user.User;
import com.group.queda_app.domain.user.UserRepository;
import com.group.queda_app.dto.user.UserDto;
import com.group.queda_app.dto.user.reponse.UserLogin;
import com.group.queda_app.dto.user.reponse.UserReponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void userLogin(UserReponse userReponse) {
        User user = userRepository.findByUserId(userReponse.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(user.toString());
    }

    @Transactional
    public UserReponse login(UserReponse userReponse) {
        // 1. 회원이 입력한 아이디로 DB에서 조회
        // 2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        //Optional<User> byUser_id = userRepository.findByUserId(userReponse.getUserId());
        User user1 = userRepository.findByUserId(userReponse.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        System.out.println("실패지점");
        System.out.println(user1.getUserId().toString());
    /*
        if (user1.isPresent()) {
            //조회 결과가 있다(해당 아이디를 가진 회원 정보가 있다.)
            User user = user1.get();
            if (user.getPassword().equals(userReponse.getPassword())) {
                //비밀번호가 일치 -> Entity -> DTO 변환 후 리턴
                UserReponse login = UserReponse.toUserReponce(user);
                return login;
            } else {
                // 비밀번호 불일치(로그인 실패)
                return null;
            }
        } else {
            //조회 결과가 없다(해당 아이디를 가진 회원이 없다.)
            System.out.println("실패지점2");
            return null;

    }*/
        return userReponse;
    }
}
//    public List<UserReponse> getUser(){
//        return userRepository.findByIdAndPwd().stream()
//                .map(UserReponse::new)
//                .collect(Collectors.toList());
//    }


