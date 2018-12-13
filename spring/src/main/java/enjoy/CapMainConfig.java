package enjoy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@Controller  @Service  @Respostry  @Component
@ComponentScan(value="enjoy", includeFilters={
		@Filter(type=FilterType.ANNOTATION, classes={Controller.class})		
}, useDefaultFilters=false)


public class CapMainConfig {
	//给容器中注册一个bean, 类型为返回值的类型, 
	@Bean
	public Person person01(){
		return new Person("james",20);
	}
}
