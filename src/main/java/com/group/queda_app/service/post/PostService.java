package com.group.queda_app.service.post;

import com.group.queda_app.domain.post.Post;
import com.group.queda_app.domain.post.PostRepository;
import com.group.queda_app.dto.post.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// DTO -> Entity
// Entity -> DTO

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

//    public void save(PostDTO postDTO){
//        Post post = post.toSaveEntity(postDTO);
//        postDTO.save(post);
//    }

    // entity로 넘어온 객체를 dto 객체로 옮겨 담아서 다시 컨트롤러로 return
    @Transactional
    public List<PostDTO> findAll(){
        // 1. storeID 조회
        // 2. DB에서 조회한 StoreId로 게시물 조회
        List<Post> postList = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();

        //E -> D
        for (Post post: postList){
            postDTOList.add(PostDTO.toPostDTO(post));
        }
        return postDTOList;
    }
    @Transactional
    public List<PostDTO> getPostList(int storeId){
        List<Object[]> posts = postRepository.findByStoreIdWithLimitedText(storeId);
        List<PostDTO> postDTOs = new ArrayList<>();
        for(Object[] post : posts) {
            PostDTO postDTO = new PostDTO();
            postDTO.setTitle((String) post[0]);
            postDTO.setText(((String) post[1]).substring(0, Math.min(((String) post[1]).length(), 30)));
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

}
