package com.group.queda_app.domain.user_isLike;

import com.group.queda_app.domain.store.Store;
import com.group.queda_app.domain.user.User;
import jakarta.persistence.*;

@Entity(name = "user_isLike")
public class UserisLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index")
    private int index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_num")
    private Store store;

    @Column(name = "prm_push")
    private boolean prmPush;

}
