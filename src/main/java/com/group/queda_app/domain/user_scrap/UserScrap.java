package com.group.queda_app.domain.user_scrap;


import com.group.queda_app.domain.post.Post;
import com.group.queda_app.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "user_scrap")
public class UserScrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
