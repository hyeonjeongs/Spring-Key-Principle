package hyeonjeongs.spring_principle.member;

import hyeonjeongs.spring_principle.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //Appconfig에 있는 환경설정정보 가지고 관리해줌
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //이름은 앞에꺼고, 타입은 뒤에정보
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
        ;
    }
}
