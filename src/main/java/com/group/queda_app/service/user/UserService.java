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
    private  final UserRepository userRepository;
    @Transactional // userID로 user 로그인
    public void userLogin(UserDto userDto) {
        // 1. 회원이 입력한 아이디로 DB에서 조회
        User user = userRepository.findByUserId(userDto.getUserId())
                .orElseThrow(IllegalArgumentException::new);
          if(user.getPassword().equals(userDto.getPassword())){
              System.out.println("비밀번호 일치");
          }else {
              System.out.println("비밀번호 불일치");
          }
          System.out.println(user.getUserId());
    }

    @Transactional // DTO 객체로 login 로직 짜는게 좋을 것 같은데....
    public UserDto login(UserDto userDto) {
        // 1. 회원이 입력한 아이디로 DB에서 조회
        // 2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
        Optional<User> byUserId = userRepository.findByUserId(userDto.getUserId());
      if (byUserId.isPresent()) {
            //조회 결과가 있다(해당 아이디를 가진 회원 정보가 있다.)
            User user = byUserId.get();
            if (user.getPassword().equals(userDto.getPassword())) {
                //비밀번호가 일치 -> Entity -> DTO 변환 후 리턴
                UserDto dto = UserDto.touserDTO(user);
                return dto;
            } else {
                // 비밀번호 불일치(로그인 실패)
                System.out.println("비밀번호 불일치");
                return null;
            }
        } else {
            //조회 결과가 없다(해당 아이디를 가진 회원이 없다.)
          System.out.println("아이디 불일치");
          return null;
        }


    }
}


