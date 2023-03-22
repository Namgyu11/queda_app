package com.group.queda_app.domain.user_keyword;

import com.group.queda_app.domain.keyword.Keyword;
import com.group.queda_app.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "user_keyword")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index")
    private int index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyNum", referencedColumnName = "key_num")
    private Keyword keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;



}
