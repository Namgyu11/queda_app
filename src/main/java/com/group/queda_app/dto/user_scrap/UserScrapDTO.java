package com.group.queda_app.dto.user_scrap;


import com.group.queda_app.domain.post.Post;
import com.group.queda_app.domain.user.User;
import com.group.queda_app.domain.user_scrap.UserScrap;
import com.group.queda_app.dto.post.PostDTO;
import com.group.queda_app.dto.user.UserDto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserScrapDTO {

    private Long index;
    private UserDto userId;
    private PostDTO postNum;
    public static UserScrapDTO convertToDto(UserScrap userScrap) {
        UserScrapDTO dto = new UserScrapDTO();
        dto.setIndex(userScrap.getIndex());
        dto.setUserId(UserDto.touserDTO(userScrap.getUserId()));
        dto.setPostNum(PostDTO.toPostDTO(userScrap.getPostNum()));
        return dto;
    }
}
