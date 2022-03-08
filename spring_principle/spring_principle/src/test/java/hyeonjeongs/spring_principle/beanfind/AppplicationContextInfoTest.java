package hyeonjeongs.spring_principle.beanfind;

import hyeonjeongs.spring_principle.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class AppplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //빈에 정의된 이름을 모두 등록
        for (String beanDefinitionName : beanDefinitionNames) {//key: name, vlaue : bean object
            Object bean = ac.getBean(beanDefinitionName); //타입을 지정안해서 객체 형태로 꺼내짐
            System.out.println("name = " + beanDefinitionName + " object = "+ bean);
        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //빈에 정의된 이름을 모두 등록
        for (String beanDefinitionName : beanDefinitionNames) {//key: name, vlaue : bean object
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //bean에 대한 메타정보 다 가져옴

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //스프링 내부에서 등록한 빈들이 아니라 내가 개발하기 위해 등록한 빈들(외부 라이브러리 같은것)
                Object bean = ac.getBean(beanDefinitionName); //타입을 지정안해서 객체 형태로 꺼내짐
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
