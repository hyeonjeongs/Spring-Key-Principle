package hyeonjeongs.spring_principle.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatafulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatafulService statefulService1 = ac.getBean(StatafulService.class);
        StatafulService statefulService2 = ac.getBean(StatafulService.class);

        //1고객 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //2고객 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //사용자1 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);

       // Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatafulService statefulService(){
            return new StatafulService();
        }
    }

}