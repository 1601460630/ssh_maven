package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.GuestDao;
import cn.itcast.domain.Guest;

//HibernateDaoSupport为dao注入sessionFactory
public class GuestDaoImpl extends HibernateDaoSupport implements GuestDao {

	// 增加拜访人
	public void addGuest(Guest guest) {

		this.getHibernateTemplate().save(guest);
	}

	// 删除拜访人
	public void deleteGuest(Guest guest) {
		
		this.getHibernateTemplate().delete(guest);
	}

	// 修改拜访人信息
	public void updateGuest(Guest guest) {
		
		this.getHibernateTemplate().update(guest);
	}

	// 通过 id 查找拜访人
	public Guest getByGuestId(Integer guest_id) {

		List<Guest> list = (List<Guest>) this.getHibernateTemplate().find(" from Guest where guest_id = ? ",guest_id);
		return list.get(0);
	}

	// 通过 姓名 查找拜访人
	public List<Guest> getByGuestName(String guest_name) {
		
		return (List<Guest>) this.getHibernateTemplate().find(" from Guest where guest_name = ? ", guest_name);
	}

	// 查找所有拜访人
	public List<Guest> getAllGuest() {
		System.out.println("这里是DAO层");
		List<Guest> list = (List<Guest>) this.getHibernateTemplate().find("from Guest");
		System.out.println("这里是DAO层" + list.size());
		System.out.println("这里是DAO层" + list);
		return (List<Guest>) this.getHibernateTemplate().find("from Guest");
	}

}
