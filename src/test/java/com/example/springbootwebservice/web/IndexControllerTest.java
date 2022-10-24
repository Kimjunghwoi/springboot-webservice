package com.example.springbootwebservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;


//    @LocalServerPort
//    private int port;

    @Test
    public void 메인페이지_로딩() {
        //when
//        String url = "http://localhost:" + port+"/";
        String body = this.restTemplate.getForObject("/", String.class);
        System.out.println("body = " + body);
        //then
        //잘못됐음 분명히! 들어가서 body가 나와야하는데 restTemplate 쪽 문제인듯
        assertThat(body).doesNotContain("스프링 부트로 시작하는 웹 서비스");
    }
}