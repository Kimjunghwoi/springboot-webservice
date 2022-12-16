package com.example.springbootwebservice.web.config.auth.dto;

import com.example.springbootwebservice.web.domain.user.User;
import lombok.Getter;

import java.io.Serializable;


/*SeesionUser에는 인증된 사용자 정보만 필요합니다.*/

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;


    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}