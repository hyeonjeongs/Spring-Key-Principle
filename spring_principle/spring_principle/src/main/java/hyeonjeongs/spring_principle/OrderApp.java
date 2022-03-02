package hyeonjeongs.spring_principle;

import hyeonjeongs.spring_principle.member.Grade;
import hyeonjeongs.spring_principle.member.Member;
import hyeonjeongs.spring_principle.member.MemberService;
import hyeonjeongs.spring_principle.member.MemberServiceImpl;
import hyeonjeongs.spring_principle.order.Order;
import hyeonjeongs.spring_principle.order.OrderService;
import hyeonjeongs.spring_principle.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("Order = " + order);
    }
}
