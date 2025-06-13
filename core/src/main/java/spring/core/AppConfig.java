package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

@Configuration //스프링이 알아서 객체를 만들고 관리하게 하기 위해 해당 클래스가 Spring 설정 파일임을 명시 -> @Bean 메서드를 스프링 컨테이너에 등록함
public class AppConfig {
    @Bean //해당 메서드가 리턴하는 객체를 컨테이너에 저장(스프링 빈으로 등록) -> new로 객체를 일일이 할당하지 않아도 적시에 스프링 컨테이너가 객체를 주입해줌
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
