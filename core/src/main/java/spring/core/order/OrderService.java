package spring.core.order;

import spring.core.member.Member;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
//    //회원 조회
//    Member findMemberById(Long memberId);
//    //할인 적용
//    int discount(Member member, int price);
}
