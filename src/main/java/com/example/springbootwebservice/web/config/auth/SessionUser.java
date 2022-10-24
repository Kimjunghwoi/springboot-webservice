package com.example.springbootwebservice.web.config.auth;

import com.example.springbootwebservice.web.domain.user.Users;
import lombok.Getter;

import java.io.Serializable;


/*SeesionUser에는 인증된 사용자 정보만 필요합니다.*/

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;


    public SessionUser(Users users) {
        this.name = users.getName();
        this.email = users.getEmail();
        this.picture = users.getPicture();
    }
}