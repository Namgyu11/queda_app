package com.group.queda_app.controller.user_scrap;

import com.group.queda_app.dto.user_scrap.UserScrapDTO;
import com.group.queda_app.service.user_scrap.UserScrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_scraps")
public class UserScrapController {

    @Autowired
    private UserScrapService userScrapService;


    @GetMapping("/user")
    public List<UserScrapDTO> getScrapedPostsByUser(@RequestParam("userId") String userId) {
        return userScrapService.getScrapedPostsByUser(userId);
    }
}