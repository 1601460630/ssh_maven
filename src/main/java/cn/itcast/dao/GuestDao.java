package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Guest;;

public interface GuestDao {
	
	//���Ӱݷ���
	void addGuest(Guest guest);
	//ɾ���ݷ���
	void deleteGuest(Guest guest);
	//�޸İݷ�����Ϣ
	void updateGuest(Guest guest);
	//ͨ��id���Ұݷ���
	Guest getByGuestId(Integer guest_id);
	//ͨ���������Ұݷ���
	List<Guest> getByGuestName(String guest_name);
	//�������аݷ���
	List<Guest> getAllGuest();

}
