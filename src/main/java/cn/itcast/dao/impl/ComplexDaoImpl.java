package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.ComplexDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Guest;
import cn.itcast.domain.LinkMan;

/**
 * 无用，保留，以便未来修改
 */
public class ComplexDaoImpl extends HibernateDaoSupport implements ComplexDao {

	public List<Customer> getByCustName(String cust_name) {
		
		return (List<Customer>) this.getHibernateTemplate().find(" from Customer where cust_name = ? ", cust_name);
	}

	public List<LinkMan> getBylkmName(String lkm_name) {

		return (List<LinkMan>) this.getHibernateTemplate().find(" from LinkMan where lkm_name = ? ", lkm_name);
	}

	public List<Guest> getByGuestName(String guest_name) {

		return (List<Guest>) this.getHibernateTemplate().find(" from Guest where guest_name = ? ", guest_name);
	}

}
