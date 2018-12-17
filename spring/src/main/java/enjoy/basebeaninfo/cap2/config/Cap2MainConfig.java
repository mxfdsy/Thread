package enjoy.basebeaninfo.cap2.config;


import enjoy.basebeaninfo.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
//@Controller  @Service  @Respostry  @Component
@ComponentScan(value="enjoy.basebeaninfo.cap2", includeFilters={
		@Filter(type=FilterType.ANNOTATION, classes={Controller.class})		
}, useDefaultFilters=false)


public class Cap2MainConfig {
	//给容器中注册一个bean, 类型为返回值的类型, 
	@Bean
	public Person person01(){
		return new Person("james",20);
	}
}
