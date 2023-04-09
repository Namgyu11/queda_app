package com.group.queda_app.dto.post;

import com.group.queda_app.domain.post.Post;
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

    public PostDTO(Post post) {
    }

    public static PostDTO toPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setPostNum(post.getPostNum());
        postDTO.setStoreId(post.getStoreId());
        postDTO.setTitle(post.getTitle());
        postDTO.setText(post.getText());
        postDTO.setImage(post.getImage());
        postDTO.setDateUpload(post.getDateUpload());
        postDTO.setPrmOnOff(post.isPrmOnOff());
        postDTO.setDatePrmStart(post.getDatePrmStart());
        postDTO.setDatePrmEnd(post.getDatePrmEnd());
        return postDTO;
    }
}
