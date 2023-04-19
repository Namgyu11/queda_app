package com.group.queda_app.domain.user_scrap;

import com.group.queda_app.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScrapRepository extends JpaRepository<UserScrap, Long> {
    List<UserScrap> findAllByUserId(Long userId);
}

