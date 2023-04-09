package com.group.queda_app.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface PostRepository  extends JpaRepository <Post,Long> {
    Optional<Post> findByStoreId(Long storeId);

    @Query("select p.title, substring(p.text, 1, 30) from post p where p.storeId = :storeId")
    List<Object[]> findByStoreIdWithLimitedText(int storeId);

}
