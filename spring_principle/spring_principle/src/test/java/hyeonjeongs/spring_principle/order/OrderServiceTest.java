package hyeonjeongs.spring_principle.order;

import hyeonjeongs.spring_principle.AppConfig;
import hyeonjeongs.spring_principle.member.Grade;
import hyeonjeongs.spring_principle.member.Member;
import hyeonjeongs.spring_principle.member.MemberService;
import hyeonjeongs.spring_principle.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        //given(회원정보주어짐)
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when(이렇게 했을때 - 저 회원정보로 아이템 가격이 10000일때)
        Order order = orderService.createOrder(memberId, "memberA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
