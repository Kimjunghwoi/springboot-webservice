package com.example.springbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebserviceApplication.class, args);
	}

/*

 SpringBootApplication 으로 인해 스프링 부트의 자동설정, 스프링 Bean 일기기와 생성을 모두 자동으로 설정된다.
 SpringBootApplication 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 한다.

 main 메소드에서 실행하는 SpringApplication.run으로 인해 내장 WAS(Web Application Server, 웹 어플리케이션 서버)를 실행한다.
 내장 WAS란 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 이야기한다.
 이렇게 되면 항상 서버에 톰캣(Tomcat)을 설치할 필요가 없게 되고, 스프링 부트로 만들어진 Jar 파일(실행 가능한 Java 패키징 파일)로 실행하면 된다.

*/

}
