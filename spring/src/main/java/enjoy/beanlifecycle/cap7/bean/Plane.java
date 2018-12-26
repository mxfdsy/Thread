package enjoy.beanlifecycle.cap7.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Plane implements ApplicationContextAware{

	private ApplicationContext applicationContext;

	public Plane(){
		System.out.println("Plane.....constructor........");
	}
	//创建对象后调用
	@PostConstruct
	public void init(){
		System.out.println("Plane.....@PostConstruct........");
	}

	//容器对象移除回调通知，销毁bean
	@PreDestroy
	public void destory(){
		System.out.println("Plane.....@PreDestroy......");
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		//将applicationContext传进来,可以拿到
		this.applicationContext = applicationContext;
	}
}
