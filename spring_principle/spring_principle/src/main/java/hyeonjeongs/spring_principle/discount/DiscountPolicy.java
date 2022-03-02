package hyeonjeongs.spring_principle.discount;

import hyeonjeongs.spring_principle.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인 대상 금액(얼마 할인될지 return)
     */
    int discount(Member member, int price);

}
