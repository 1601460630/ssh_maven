package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Guest;
import cn.itcast.domain.LinkMan;

/**
 * ���ã��������Ա�δ���޸ģ���ʵ�����᲻��ɾ��
 */
public interface ComplexService {

	//���ҿͻ���Ϣ
	List<Customer> getCustomerByName(String name); 	
	//������ϵ����Ϣ
	List<LinkMan> getLinkManByName(String name); 	
	//���Ұݷ���Ϣ
	List<Guest> getGuestByName(String name); 	
}
