package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerService {
	//增加客户
	boolean addCustomer(Customer cust);
	//删除客户
	boolean deleteCustomer(Customer cust);
	//修改客户信息
	boolean updateCustomer(Customer cust);
	//通过姓名查找客户
	Customer getCustomerById(Integer id); 
	//通过姓名查找客户
	List<Customer> getCustomerByName(String name); 	
	//查找所有客户
	List<Customer> listCustomer();
	
}
