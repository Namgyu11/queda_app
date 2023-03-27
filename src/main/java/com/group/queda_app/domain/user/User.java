package com.group.queda_app.domain.user;


import com.group.queda_app.domain.user_isLike.UserisLike;

import com.group.queda_app.domain.user_scrap.UserScrap;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num")
    private Long userNum;

    @Column(nullable = false, length = 255, name = "user_id")
    private String userId;
    @Column
    private String password;

    @Column(nullable = false, unique = true, length = 25, name = "user_name")
    private String user_name;
    @Column
    private String address;
    @Column
    private String nickname;
    @Column
    private String email;
    @Column
    private boolean is_admin;
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL)
    private List<UserisLike> userIsLikes = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserScrap> userScraps = new ArrayList<>();
}
