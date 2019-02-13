package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerService {
	//���ӿͻ�
	boolean addCustomer(Customer cust);
	//ɾ���ͻ�
	boolean deleteCustomer(Customer cust);
	//�޸Ŀͻ���Ϣ
	boolean updateCustomer(Customer cust);
	//ͨ���������ҿͻ�
	Customer getCustomerById(Integer id); 
	//ͨ���������ҿͻ�
	List<Customer> getCustomerByName(String name); 	
	//�������пͻ�
	List<Customer> listCustomer();
	
}
