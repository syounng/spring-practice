package spring.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AppConfig;
import spring.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest() {
        //private으로 생성자를 막아두었으므로 컴파일 오류가 발생한다.
        //SingletonService singletonService = new SingletonService();

        //1. 조회 : 호출할 때마다 같은 객체를 반환
        SingletonService singletonService1 = SingletonService.getInstance();
        //2. 조회 : 호출할 때마다 같은 객체를 반환
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 같은 것을 확인
        System.out.println("singletonService1 : " + singletonService1);
        System.out.println("singletonService2 : " + singletonService2);
    }

//    @Test
//    @DisplayName("싱글톤 패턴이 아님을 검사")
//    public void notSingleton(){
//        SingletonService instance1 = new SingletonService();
//        SingletonService instance2 = new SingletonService();
//
//        assertThat(instance1).isInstanceOf(SingletonService.class);
//        System.out.println("instance1 : " + instance1);
//        System.out.println("instance2 : " + instance2);
//    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤") void springContainer() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService",
                MemberService.class);
        //2. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService",
                MemberService.class);
        //참조값이 같은 것을 확인
        System.out.println("memberService1 = " + memberService1); System.out.println("memberService2 = " + memberService2);
        //memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }
}
