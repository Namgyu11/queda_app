package com.group.queda_app.dto.post;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int postNum;
    private int storeId;
    private String title;
    private String text;
    private String image;
    private LocalDateTime dateUpload;
    private boolean prmOnOff;
    private LocalDate datePrmStart;
    private LocalDate datePrmEnd;
}
