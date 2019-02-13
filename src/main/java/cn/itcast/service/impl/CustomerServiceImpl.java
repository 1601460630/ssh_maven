package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;

//这里对应的是application.xml配置文件中的 tx:advice 部分，用注释的写法可以配置文件里面少写点			下面千万不能用true，否则就不能进行数据库操作了
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cd;
	//增
	public boolean addCustomer(Customer cust) {
		// 设置初始值为false
		boolean flag = false;
		
		if(cust.getCust_name() == null || cust.getCust_name().equals(""))
			return flag;
		try {
			// 调用DAO里面的方法,执行数据库操作
			cd.addCustomer(cust);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//删
	public boolean deleteCustomer(Customer cust) {
		// 设置初始值为false
		boolean flag = false;
		try {
			// 调用DAO里面的方法,执行数据库操作
			cd.deleteCustomer(cust);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//改
	public boolean updateCustomer(Customer cust) {
		// 设置初始值为false
		boolean flag = false;

		try {
			// 调用DAO里面的方法,执行数据库操作
			cd.updateCustomer(cust);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//通过id查
	public Customer getCustomerById(Integer id) {
		//返回查找到的客户
		return cd.getByCustId(id);
	}
	//通过姓名查
	public List<Customer> getCustomerByName(String name) {
		//返回查找到的客户
		return cd.getByCustName(name);
	}
	
	//查所有
	public List<Customer> listCustomer() {
		
		//查找所有客户		
		return cd.getAllCustomer();//简单到我在怀疑自己的正确性
	}

	
	//这一段似乎可以删掉，没做测试
	public CustomerDao getCd() {
		return cd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	

}
