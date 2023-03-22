package com.group.queda_app.domain.store;

import com.group.queda_app.domain.store_keyword.StoreKeyword;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_num")
    private int storeNum;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "store_info", nullable = false)
    private String storeInfo;

    @Column(name = "store_opentime", nullable = false)
    private String storeOpentime;

    @Column(name = "store_address", nullable = false)
    private String storeAddress;

    @Column(name = "store_latitude", nullable = false)
    private BigDecimal storeLatitude;

    @Column(name = "store_longitude", nullable = false)
    private BigDecimal storeLongitude;

    @Column(name = "date_registration", nullable = false)
    private LocalDateTime dateRegistration;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreKeyword> storeKeywords = new ArrayList<>();

}
