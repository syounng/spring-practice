package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig(); //스프링 컨테이너 만들기 전 -> 직접 new 연산자로 AppConfig 객체를 만듦
//        MemberService memberService = appConfig.memberService(); //AppConfig의 memberService()를 직접 호출하여 객체를 꺼냄

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //스프링 컨테이너 만든 후 -> AnnotaionConfigApplicationContext()에 AppConfig 객체를 넘겨줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //AppConfig의 MemberService()를 직접 호출하지 않고 getBean()메서드를 통해 호출하여 객체를 꺼냄

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
