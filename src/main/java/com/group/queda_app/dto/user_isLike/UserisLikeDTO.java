package com.group.queda_app.dto.user_isLike;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserisLikeDTO {

    private Long index;
    private String userId;
    private Long storeId;
    private boolean prmPush;
}
