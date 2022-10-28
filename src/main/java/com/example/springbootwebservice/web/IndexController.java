package com.example.springbootwebservice.web;

import com.example.springbootwebservice.web.config.auth.LoginUser;
import com.example.springbootwebservice.web.config.auth.SessionUser;
import com.example.springbootwebservice.web.dto.PostsResponseDto;
import com.example.springbootwebservice.web.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    /*
    (SessionUser) httpSession.getAttribute("user")
        앞서 작성된 CustomOAuth2ervice에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성했습니다.
        즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있습니다.
    if(user != null)
        세션에 저장된 값이 있을 때만 model에 userName으로 등록됩니다.
    LoginUser SessionUser user
        기존에 httpSession.getAttribute("user")로 가져오던 세션 정보 값이 개선되었습니다.
        이제는 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있게 되었습니다.
    */

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user"); annotation 대체

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index"; //  mustache에서 파일 경로와 확장자는 자동 지정함.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
