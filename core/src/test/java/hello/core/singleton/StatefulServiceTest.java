package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(testConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);

        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);


        //ThreadA : A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //Thread B : B 사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

//        int price = statefulService1.getPrice();

        //10000원을 기대했지만, 기대와 다르게 20000원 출력
//        System.out.println("price = " + price);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);


        System.out.println("userAPrice = " + userAPrice);


    }


    static class testConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
