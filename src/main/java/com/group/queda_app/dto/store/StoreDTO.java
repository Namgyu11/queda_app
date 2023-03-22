package com.group.queda_app.dto.store;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StoreDTO {
    private int storeNum;

    private String storeName;

    private long userId;

    private String storeInfo;

    private String storeOpentime;

    private String storeAddress;

    private BigDecimal storeLatitude;

    private BigDecimal storeLongitude;

    private LocalDateTime dateRegistration;
}
