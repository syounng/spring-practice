package spring.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.plaf.nimbus.State;

public class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 패턴에서 stateful한 객체 사용")
    public void isStatefulInstance(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService instance1 = ac.getBean(StatefulService.class);
        StatefulService instance2 = ac.getBean(StatefulService.class);

        instance1.order("kim", 1000);
        instance2.order("lee", 2000);

        //같은 인스턴스를 참조하고 있고 마지막에 값을 2000으로 바꿨으므로
        //fail
        Assertions.assertThat(instance1.getPrice()).isEqualTo(1000);

        //pass
        Assertions.assertThat(instance2.getPrice()).isEqualTo(2000);

        //isSameAs()로 같은 객체인지(참조하는 메모리 주소가 같은지) 확인
        Assertions.assertThat(instance1).isSameAs(instance2);

    }

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
