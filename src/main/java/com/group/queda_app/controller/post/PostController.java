package com.group.queda_app.controller.post;

import com.group.queda_app.dto.post.PostDTO;
import com.group.queda_app.dto.user.UserDto;
import com.group.queda_app.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

//    @GetMapping("/")
//    public String findAll(Model model){
//        // DB에서 전체 게시글 데이터를 가져와서 list를 보여준다.
//        List<PostDTO> postDTOList = postService.findAll();
//        model.addAttribute("postList",postDTOList);
//
//        return "List";
//   }

    // /api/posts/{storeId} GET 요청 처리 메소드
    @GetMapping("/")
    public ResponseEntity<List<PostDTO>> getPosts(@RequestParam int storeId) {
        // PostService의 getPostsWithLimitedText 메소드 호출
        List<PostDTO> postDTOs = postService.getPostList(storeId);
        // 결과가 비어있는 경우 noContent 반환
        if (postDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
            // 결과가 비어있지 않은 경우 ok를 사용하여 결과 반환
        } else {
            return ResponseEntity.ok(postDTOs);
        }
    }
    //게시물 수정
}
