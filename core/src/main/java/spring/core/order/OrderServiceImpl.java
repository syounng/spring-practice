package spring.core.order;

import spring.core.discount.DiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 조회
        Member member = memberRepository.findById(memberId);
        //할인 적용
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //주문 생성, 주문 결과 반환
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


//    @Override
//    public Member findMemberById(Long memberId) {
//        return memberRepository.findById(memberId);
//
//    }
//
//    @Override
//    public int discount(Member member, int price) {
//        return discountPolicy.discount(member, price);
//    }
}
