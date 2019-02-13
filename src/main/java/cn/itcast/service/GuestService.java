package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Guest;

public interface GuestService {
	//���Ӱݷ���
	boolean addGuest(Guest guest);
	//ɾ���ݷ���
	boolean deleteGuest(Guest guest);
	//�޸İݷ�����Ϣ
	boolean updateGuest(Guest guest);
	//ͨ���������Ұݷ���
	Guest getGuestById(Integer id); 
	//ͨ���������Ұݷ���
	List<Guest> getGuestByName(String name); 	
	//�������аݷ���
	List<Guest> listGuest();
	
}
