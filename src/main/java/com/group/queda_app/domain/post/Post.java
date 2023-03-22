package com.group.queda_app.domain.post;

import com.group.queda_app.domain.user_scrap.UserScrap;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_num")
    private int postNum;

    @Column(name = "store_id", nullable = false)
    private int storeId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "date_upload", nullable = false)
    private LocalDateTime dateUpload;

    @Column(name = "prm_onoff", nullable = false)
    private boolean prmOnOff;

    @Column(name = "date_prm_start")
    private LocalDate datePrmStart;

    @Column(name = "date_prm_end")
    private LocalDate datePrmEnd;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<UserScrap> userScraps = new ArrayList<>();
}
