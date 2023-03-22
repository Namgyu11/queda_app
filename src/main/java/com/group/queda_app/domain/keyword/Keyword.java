package com.group.queda_app.domain.keyword;

import com.group.queda_app.domain.store_keyword.StoreKeyword;
import com.group.queda_app.domain.user_keyword.UserKeyword;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "keyword")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_num")
    private int keyNum;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<UserKeyword> userKeywords = new ArrayList<>();
    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<StoreKeyword> storeKeywords = new ArrayList<>();

}
