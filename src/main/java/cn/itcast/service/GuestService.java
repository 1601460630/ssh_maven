package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Guest;

public interface GuestService {
	//增加拜访人
	boolean addGuest(Guest guest);
	//删除拜访人
	boolean deleteGuest(Guest guest);
	//修改拜访人信息
	boolean updateGuest(Guest guest);
	//通过姓名查找拜访人
	Guest getGuestById(Integer id); 
	//通过姓名查找拜访人
	List<Guest> getGuestByName(String name); 	
	//查找所有拜访人
	List<Guest> listGuest();
	
}
