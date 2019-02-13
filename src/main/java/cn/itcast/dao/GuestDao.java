package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Guest;;

public interface GuestDao {
	
	//增加拜访人
	void addGuest(Guest guest);
	//删除拜访人
	void deleteGuest(Guest guest);
	//修改拜访人信息
	void updateGuest(Guest guest);
	//通过id查找拜访人
	Guest getByGuestId(Integer guest_id);
	//通过姓名查找拜访人
	List<Guest> getByGuestName(String guest_name);
	//查找所有拜访人
	List<Guest> getAllGuest();

}
