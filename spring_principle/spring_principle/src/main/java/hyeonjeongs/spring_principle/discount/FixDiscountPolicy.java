package hyeonjeongs.spring_principle.discount;

import hyeonjeongs.spring_principle.member.Grade;
import hyeonjeongs.spring_principle.member.Member;
import org.apache.commons.logging.Log;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //VIP면 천원 할인
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
