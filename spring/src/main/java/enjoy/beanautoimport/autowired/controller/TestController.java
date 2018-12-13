package enjoy.beanautoimport.autowired.controller;


import enjoy.beanautoimport.autowired.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	@Autowired
	private TestService testService;
}
