package beanautoimport;

import enjoy.beanautoimport.value.Bird;
import enjoy.beanautoimport.value.CapConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class valueTest {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(CapConfig.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Bird bird = (Bird) app.getBean("bird");
        ConfigurableEnvironment environment = app.getEnvironment();
        System.out.println(environment.getProperty("bird.color"));

        System.out.println(bird);
        System.out.println("ioc容器创建完成");
        app.close();
    }
}
