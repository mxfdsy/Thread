package enjoy.beanautoimport.autowired.service;


import enjoy.beanautoimport.autowired.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {

//	@Qualifier("testDao")
//	@Autowired(required = false)
	@Resource
	private TestDao testDao;

	public void println() {
		System.out.println("TestService ...testDao.." + testDao);
	}

}
