package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.GuestDao;
import cn.itcast.domain.Guest;
import cn.itcast.service.GuestService;

//�����Ӧ����application.xml�����ļ��е� tx:advice ���֣���ע�͵�д�����������ļ�������д��			����ǧ������true������Ͳ��ܽ������ݿ������
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class GuestServiceImpl implements GuestService {

	private GuestDao gd;
	//��
	public boolean addGuest(Guest guest) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;

		if(guest.getGuest_name() == null || guest.getGuest_name().equals(""))
			return flag;

		try {
			// ����DAO����ķ���,ִ�����ݿ����
			gd.addGuest(guest);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//ɾ
	public boolean deleteGuest(Guest guest) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;
		try {
			// ����DAO����ķ���,ִ�����ݿ����
			gd.deleteGuest(guest);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//��
	public boolean updateGuest(Guest guest) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;

		try {
			// ����DAO����ķ���,ִ�����ݿ����
			gd.updateGuest(guest);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//ͨ��id��
	public Guest getGuestById(Integer id) {
		
		//ͨ��id���Ұݷ���	
		return gd.getByGuestId(id);
	}
	
	public List<Guest> getGuestByName(String name) {
		
		return gd.getByGuestName(name);
	}
	
	//������
	public List<Guest> listGuest() {
		System.out.println("������Service��");
		//�������аݷ���		
		return gd.getAllGuest();//�򵥵����ڻ����Լ�����ȷ��
	}

	
	//��һ���ƺ�����ɾ����û������
	public GuestDao getgd() {
		return gd;
	}

	public void setgd(GuestDao gd) {
		this.gd = gd;
	}

	

}
