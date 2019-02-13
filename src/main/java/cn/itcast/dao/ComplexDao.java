package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Guest;
import cn.itcast.domain.LinkMan;

/**
 * ���ã��������Ա�δ���޸�
 */
public interface ComplexDao {
	
	//�ͻ���Ϣ��ѯ
	List<Customer> getByCustName(String cust_name);
	//��ϵ����Ϣ��ѯ
	List<LinkMan> getBylkmName(String lkm_name);
	//�ݷ���Ϣ��ѯ
	List<Guest> getByGuestName(String guest_name);
}
