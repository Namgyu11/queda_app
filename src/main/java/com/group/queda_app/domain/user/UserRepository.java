package com.group.queda_app.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //User findByName(String name)

    //아이디로 회원 정보 조회 (select * from user where id = ?)
   // @Query(value = "select * from user where user_id = ?", nativeQuery = true)
    Optional<User> findByUserId(String userId);

}
