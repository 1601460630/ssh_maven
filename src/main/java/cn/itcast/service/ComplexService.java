package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Guest;
import cn.itcast.domain.LinkMan;

/**
 * 无用，保留，以便未来修改（其实就是舍不得删）
 */
public interface ComplexService {

	//查找客户信息
	List<Customer> getCustomerByName(String name); 	
	//查找联系人信息
	List<LinkMan> getLinkManByName(String name); 	
	//查找拜访信息
	List<Guest> getGuestByName(String name); 	
}
