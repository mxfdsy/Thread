package Transactional;


import enjoy.Transactional.Config.Cap11MainConfig;
import enjoy.Transactional.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Cap11Test {
	@Test
	public void test01(){
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap11MainConfig.class);
		
		OrderService bean = app.getBean(OrderService.class);
		bean.addOrder();
		
		app.close();
	
		
	}
}
