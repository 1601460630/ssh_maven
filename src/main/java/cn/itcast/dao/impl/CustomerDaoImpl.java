package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;

//HibernateDaoSupportΪdaoע��sessionFactory
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	// ���ӿͻ�
	public void addCustomer(Customer cust) {

		this.getHibernateTemplate().save(cust);
	}

	// ɾ���ͻ�this.getSessionFactory().openSession().createSQLQuery("SELECT cust_industry `��ҵ`,count(cust_industry) `�ܼ�` FROM cst_customer GROUP BY cust_industry;");
	public void deleteCustomer(Customer cust) {
		
		this.getHibernateTemplate().delete(cust);
	}

	// �޸Ŀͻ���Ϣ
	public void updateCustomer(Customer cust) {
		
		this.getHibernateTemplate().update(cust);
	}

	// ͨ�� id ���ҿͻ�
	public Customer getByCustId(Integer cust_id) {

		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find(" from Customer where cust_id = ? ",cust_id);
		return list.get(0);
	}

	// ͨ�� ���� ���ҿͻ�
	public List<Customer> getByCustName(String cust_name) {

		return (List<Customer>) this.getHibernateTemplate().find(" from Customer where cust_name = ? ", cust_name);
	}

	// �������пͻ�
	public List<Customer> getAllCustomer() {

		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

}
