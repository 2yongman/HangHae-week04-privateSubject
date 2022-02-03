package com.sparta.wekk043thproject.controller;

import com.sparta.wekk043thproject.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("username", userDetails.getUsername());
        return "index2";
    }

    //게시글 작성 넘어가기
    @GetMapping("/Board/write")
    public String write(){
        return "boardwrite";
    }

    //게시글 세부 페이지 넘어가기
    @GetMapping("/Board/detail")
    public String detail(){
        return "detail";
    }

}
