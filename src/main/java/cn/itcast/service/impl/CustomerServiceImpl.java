package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;

//�����Ӧ����application.xml�����ļ��е� tx:advice ���֣���ע�͵�д�����������ļ�������д��			����ǧ������true������Ͳ��ܽ������ݿ������
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cd;
	//��
	public boolean addCustomer(Customer cust) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;
		
		if(cust.getCust_name() == null || cust.getCust_name().equals(""))
			return flag;
		try {
			// ����DAO����ķ���,ִ�����ݿ����
			cd.addCustomer(cust);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//ɾ
	public boolean deleteCustomer(Customer cust) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;
		try {
			// ����DAO����ķ���,ִ�����ݿ����
			cd.deleteCustomer(cust);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//��
	public boolean updateCustomer(Customer cust) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;

		try {
			// ����DAO����ķ���,ִ�����ݿ����
			cd.updateCustomer(cust);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//ͨ��id��
	public Customer getCustomerById(Integer id) {
		//���ز��ҵ��Ŀͻ�
		return cd.getByCustId(id);
	}
	//ͨ��������
	public List<Customer> getCustomerByName(String name) {
		//���ز��ҵ��Ŀͻ�
		return cd.getByCustName(name);
	}
	
	//������
	public List<Customer> listCustomer() {
		
		//�������пͻ�		
		return cd.getAllCustomer();//�򵥵����ڻ����Լ�����ȷ��
	}

	
	//��һ���ƺ�����ɾ����û������
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	

}
