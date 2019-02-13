package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.GuestDao;
import cn.itcast.domain.Guest;

//HibernateDaoSupportΪdaoע��sessionFactory
public class GuestDaoImpl extends HibernateDaoSupport implements GuestDao {

	// ���Ӱݷ���
	public void addGuest(Guest guest) {

		this.getHibernateTemplate().save(guest);
	}

	// ɾ���ݷ���
	public void deleteGuest(Guest guest) {
		
		this.getHibernateTemplate().delete(guest);
	}

	// �޸İݷ�����Ϣ
	public void updateGuest(Guest guest) {
		
		this.getHibernateTemplate().update(guest);
	}

	// ͨ�� id ���Ұݷ���
	public Guest getByGuestId(Integer guest_id) {

		List<Guest> list = (List<Guest>) this.getHibernateTemplate().find(" from Guest where guest_id = ? ",guest_id);
		return list.get(0);
	}

	// ͨ�� ���� ���Ұݷ���
	public List<Guest> getByGuestName(String guest_name) {
		
		return (List<Guest>) this.getHibernateTemplate().find(" from Guest where guest_name = ? ", guest_name);
	}

	// �������аݷ���
	public List<Guest> getAllGuest() {
		System.out.println("������DAO��");
		List<Guest> list = (List<Guest>) this.getHibernateTemplate().find("from Guest");
		System.out.println("������DAO��" + list.size());
		System.out.println("������DAO��" + list);
		return (List<Guest>) this.getHibernateTemplate().find("from Guest");
	}

}
