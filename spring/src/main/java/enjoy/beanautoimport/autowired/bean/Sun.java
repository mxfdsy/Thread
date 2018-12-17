package enjoy.beanautoimport.autowired.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sun {
	private Moon moon;

//	@Autowired
	public Sun(@Autowired Moon moon){
		this.moon = moon;
//		System.out.println("..Constructor................");
	}

//	public Sun() {
//	}

	public Moon getMoon() {
		return moon;
	}

	//@Autowired 可以作用在方法上面，在spring启动时就会调用该方法
//	@Autowired
	public void setMoon(Moon moon) {
		System.out.println("do  work");
		this.moon = moon;
	}

	@Override
	public String toString() {
		return "Sun [moon=" + moon + "]";
	}
}
