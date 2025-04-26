package spring.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;

public class OrderServiceTest {
    //회원 만들고 회원가입 시키고 주문 한 개 생성하기
    MemberService memberService;
    OrderService orderService;

    @Test
    public void createOrder(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
        //then
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000); //vip인 경우 1000원 할인해주기로 함
    }
}
