package beanautoimport.autowired;


import enjoy.beanautoimport.autowired.bean.Moon;
import enjoy.beanautoimport.autowired.bean.Sun;
import enjoy.beanautoimport.autowired.config.CapMainAutowiredConfig;
import enjoy.beanautoimport.autowired.dao.TestDao;
import enjoy.beanautoimport.autowired.service.TestService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class autowiredTest {


    @Test
    public void test01(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(CapMainAutowiredConfig.class);
        TestService testService = app.getBean(TestService.class);
        testService.println();

//        TestDao testDao = app.getBean(TestDao.class);
//        System.out.println(testDao);
    }



    @Test
    public void test02(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(CapMainAutowiredConfig.class);
        Sun sun = app.getBean(Sun.class);
        System.out.println(sun);

        Moon moon = app.getBean(Moon.class);
        System.out.println(moon);

    }


}
