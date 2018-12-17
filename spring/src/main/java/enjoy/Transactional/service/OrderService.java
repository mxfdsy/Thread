package enjoy.Transactional.service;

import enjoy.Transactional.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
	private OrderDao orderDao;

    @Transactional
    public void addOrder(){
    	orderDao.insert();
    	System.out.println("insert database complete.........");
    	
    	int a = 1/0;
    }
}
