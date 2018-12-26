package enjoy.beanlifecycle.cap7.config;



import enjoy.basebeaninfo.cap1.Person;
import enjoy.beanlifecycle.cap7.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("enjoy.beanlifecycle.cap7.bean")
@Configuration
public class Cap7MainConfigOfLifeCycle {

	@Bean("person")
	public Person person(){
		System.out.println("ioc add person.......");
		return new Person("person",20);
	}

	@Bean(initMethod="init", destroyMethod="destory")
	public Bike bike(){
		return new Bike();
	}
	
}
