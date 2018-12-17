package enjoy.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * aop 面向切面编程[底层就是动态代理]
 */
@Configuration
//开启aop
@EnableAspectJAutoProxy
public class MainConfigAop {
    @Bean
    public  Calculator calculator() {
        return new Calculator();
    }

    //加入容器
    @Bean
    public  LogAspects logAspects() {
        return new LogAspects();
    }
}
