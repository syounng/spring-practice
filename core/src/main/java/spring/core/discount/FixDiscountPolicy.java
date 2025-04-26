package spring.core.discount;

import spring.core.member.Grade;
import spring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        //해당 멤버의 등급이 VIP이면 1000원 할인해주기
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else return 0;
    }
}
