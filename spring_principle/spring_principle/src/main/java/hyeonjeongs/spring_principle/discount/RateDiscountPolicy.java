package hyeonjeongs.spring_principle.discount;

import hyeonjeongs.spring_principle.member.Grade;
import hyeonjeongs.spring_principle.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent /100;
        }else {
            return 0;
        }
    }
}
