package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.GuestDao;
import cn.itcast.domain.Guest;
import cn.itcast.service.GuestService;

//这里对应的是application.xml配置文件中的 tx:advice 部分，用注释的写法可以配置文件里面少写点			下面千万不能用true，否则就不能进行数据库操作了
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class GuestServiceImpl implements GuestService {

	private GuestDao gd;
	//增
	public boolean addGuest(Guest guest) {
		// 设置初始值为false
		boolean flag = false;

		if(guest.getGuest_name() == null || guest.getGuest_name().equals(""))
			return flag;

		try {
			// 调用DAO里面的方法,执行数据库操作
			gd.addGuest(guest);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//删
	public boolean deleteGuest(Guest guest) {
		// 设置初始值为false
		boolean flag = false;
		try {
			// 调用DAO里面的方法,执行数据库操作
			gd.deleteGuest(guest);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//改
	public boolean updateGuest(Guest guest) {
		// 设置初始值为false
		boolean flag = false;

		try {
			// 调用DAO里面的方法,执行数据库操作
			gd.updateGuest(guest);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//通过id查
	public Guest getGuestById(Integer id) {
		
		//通过id查找拜访人	
		return gd.getByGuestId(id);
	}
	
	public List<Guest> getGuestByName(String name) {
		
		return gd.getByGuestName(name);
	}
	
	//查所有
	public List<Guest> listGuest() {
		System.out.println("这里是Service层");
		//查找所有拜访人		
		return gd.getAllGuest();//简单到我在怀疑自己的正确性
	}

	
	//这一段似乎可以删掉，没做测试
	public GuestDao getgd() {
		return gd;
	}

	public void setgd(GuestDao gd) {
		this.gd = gd;
	}

	

}
