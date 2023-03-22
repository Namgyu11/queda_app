package com.group.queda_app.domain.store_keyword;

import com.group.queda_app.domain.keyword.Keyword;
import com.group.queda_app.domain.store.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "store_keyword")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreKeyword {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index")
    private int index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "keyNum", referencedColumnName = "key_num")
    private Keyword keyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", referencedColumnName = "store_num")
    private Store store;

}
