package beanautoimport.aop;

import enjoy.aop.Calculator;
import enjoy.aop.MainConfigAop;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    @Test
    public void  test01() throws Exception {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfigAop.class);
        Calculator c = app.getBean(Calculator.class);
        int result = c.div(2, 2);
        System.out.println(result);

    }
}
