package spring.core.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    private DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //RateDiscountPolicy가 10% 할인을 해주는지 검증
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    public void vip_o(){
//        //given
//        int discountPercent = 10;
//        Member member = new Member(1L, "memberA", Grade.VIP);
//        memberService.join(member);
//        //when
//        Order order = orderService.createOrder(member.getId(), "itemA", 10000);
//        //then
//        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    public void vip_x(){
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}