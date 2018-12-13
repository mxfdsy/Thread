package enjoy.beanautoimport.autowired.config;

import enjoy.beanautoimport.autowired.dao.TestDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"enjoy.beanautoimport.autowired.controller","enjoy.beanautoimport.autowired.service","enjoy.beanautoimport.autowired.dao"})
public class CapMainAutowiredConfig {

    @Primary
    @Bean("testDao2")
	public  TestDao testDao() {
        TestDao testDao = new TestDao();
        testDao.setFlag("2");
        return testDao;
    }

}
