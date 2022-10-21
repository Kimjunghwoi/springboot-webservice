package com.example.springbootwebservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; //  mustache에서 파일 경로와 확장자는 자동 지정함.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
