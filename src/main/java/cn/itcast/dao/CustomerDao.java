package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;

public interface CustomerDao {
	
	//���ӿͻ�
	void addCustomer(Customer cust);
	//ɾ���ͻ�
	void deleteCustomer(Customer cust);
	//�޸Ŀͻ���Ϣ
	void updateCustomer(Customer cust);
	//ͨ��id���ҿͻ�
	Customer getByCustId(Integer cust_id);
	//ͨ���������ҿͻ�
	List<Customer> getByCustName(String cust_name);
	//�������пͻ�
	List<Customer> getAllCustomer();

}
