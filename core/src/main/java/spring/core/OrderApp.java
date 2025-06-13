package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.order.Order;
import spring.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        //멤버 생성하고 회원가입 시키고
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //주문하기
        Order order = orderService.createOrder(member.getId(), "item1", 10000);

        //주문 출력해보기
        System.out.println(order);
        System.out.println("calculate price : " + order.calculatePrice());
    }

}
