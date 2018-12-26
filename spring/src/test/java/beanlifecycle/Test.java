package beanlifecycle;

import enjoy.beanlifecycle.cap7.config.Cap7MainConfigOfLifeCycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    @org.junit.Test
    public void  test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap7MainConfigOfLifeCycle.class);
        System.out.println("IOC created complete");


    }
}
