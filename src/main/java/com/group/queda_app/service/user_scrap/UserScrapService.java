package com.group.queda_app.service.user_scrap;

import com.group.queda_app.domain.user.User;
import com.group.queda_app.domain.user.UserRepository;
import com.group.queda_app.domain.user_scrap.UserScrap;
import com.group.queda_app.domain.user_scrap.UserScrapRepository;
import com.group.queda_app.dto.user_scrap.UserScrapDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserScrapService {

    @Autowired
    private UserScrapRepository userScrapRepository;
    @Autowired
    private UserRepository userRepository;

    public List<UserScrapDTO> getScrapedPostsByUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(); // Change long to String
        List<UserScrap> userScraps = userScrapRepository.findAllByUserId(userId); // Change Long.valueOf to userId
        return userScraps.stream().map(UserScrapDTO::convertToDto).collect(Collectors.toList());
    }




}
