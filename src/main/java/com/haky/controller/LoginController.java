package com.haky.controller;

import com.haky.annotation.SocialUser;
import com.haky.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    // incheol test
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        return "redirect:/board/list";
    }
}
