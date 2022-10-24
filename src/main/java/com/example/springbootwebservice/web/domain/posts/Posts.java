package com.example.springbootwebservice.web.domain.posts;

import com.example.springbootwebservice.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
    @Entity
        테이블과 링크될 클래스임을 나타낸다.
        기본값으로 클래스의 카멜케이스 이름을 언더 스코어 네이밍(_)으로 테이블 이름을 매칭한다.
        ex) SalesManager.java -> sales_manager table
    @GeneratedValue
        PK 생성 규칙
        스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 autoIncrement 된다.
*/

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

/*
    @Id
        해당 테이블의 PK 필드를 나타낸다.
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
    @Column
        테이블의 컬럼을 나타내며 굳이 선언하지 않더라고 해당 클래스의 필드는 모두 컬럼이 된다.
        사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵셥이 있으면 사용한다.
*/

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

/*
    @Builder
        해당 클래스의 빌더 패턴 클래스를 생성
        생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
*/
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

/*
    이 Posts 클래스에는 한 가지 특이점이 있습니다. setter 메소드가 없다는 점입니다.
    자바빈 규약을 생각하면서 getter/setter를 무작정 생성하는 경우 클래스의 인스턴스 값들이 언제 변경되는지 명확하게 알 수 없습니다.

    Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
*/

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
