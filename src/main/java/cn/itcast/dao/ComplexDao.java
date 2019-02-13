package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Guest;
import cn.itcast.domain.LinkMan;

/**
 * 无用，保留，以便未来修改
 */
public interface ComplexDao {
	
	//客户信息查询
	List<Customer> getByCustName(String cust_name);
	//联系人信息查询
	List<LinkMan> getBylkmName(String lkm_name);
	//拜访信息查询
	List<Guest> getByGuestName(String guest_name);
}
