package beanautoimport.autowired;


import enjoy.beanautoimport.autowired.config.CapMainAutowiredConfig;
import enjoy.beanautoimport.autowired.dao.TestDao;
import enjoy.beanautoimport.autowired.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class autowiredTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(CapMainAutowiredConfig.class);
        TestService testService = app.getBean(TestService.class);
        testService.println();

//        TestDao testDao = app.getBean(TestDao.class);
//        System.out.println(testDao);
    }

}
