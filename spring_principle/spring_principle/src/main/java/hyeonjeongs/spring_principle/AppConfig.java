package hyeonjeongs.spring_principle;

import hyeonjeongs.spring_principle.discount.DiscountPolicy;
import hyeonjeongs.spring_principle.discount.FixDiscountPolicy;
import hyeonjeongs.spring_principle.discount.RateDiscountPolicy;
import hyeonjeongs.spring_principle.member.MemberRepository;
import hyeonjeongs.spring_principle.member.MemberService;
import hyeonjeongs.spring_principle.member.MemberServiceImpl;
import hyeonjeongs.spring_principle.member.MemoryMemberRepository;
import hyeonjeongs.spring_principle.order.OrderService;
import hyeonjeongs.spring_principle.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() { //구현 클레스 불러오면 실행하도록!
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
       // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
