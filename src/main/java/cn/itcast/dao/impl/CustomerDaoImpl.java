package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

//HibernateDaoSupport为dao注入sessionFactory
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	// 增加客户
	public void addCustomer(Customer cust) {

		this.getHibernateTemplate().save(cust);
	}

	// 删除客户this.getSessionFactory().openSession().createSQLQuery("SELECT cust_industry `行业`,count(cust_industry) `总计` FROM cst_customer GROUP BY cust_industry;");
	public void deleteCustomer(Customer cust) {
		
		this.getHibernateTemplate().delete(cust);
	}

	// 修改客户信息
	public void updateCustomer(Customer cust) {
		
		this.getHibernateTemplate().update(cust);
	}

	// 通过 id 查找客户
	public Customer getByCustId(Integer cust_id) {

		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(" from Customer where cust_id = ? ",cust_id);
		return list.get(0);
	}

	// 通过 姓名 查找客户
	public List<Customer> getByCustName(String cust_name) {

		return (List<Customer>) this.getHibernateTemplate().find(" from Customer where cust_name = ? ", cust_name);
	}

	// 查找所有客户
	public List<Customer> getAllCustomer() {

		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

}
