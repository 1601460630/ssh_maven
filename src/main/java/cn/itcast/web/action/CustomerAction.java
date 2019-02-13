package cn.itcast.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
//客户操作																//模型驱动
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer cust = new Customer();
	// 注入Service
	private CustomerService customerService;
	
	//可以通过set/get获取一些小属性
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	// 添加联系人
	public String add() {

		boolean flag = false;
		// 1.调用Service执行查找逻辑
		flag = customerService.addCustomer(cust);
		// 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;

	}
	
	//删除
	public String delete() {

		boolean flag = false;
		
		Customer customer = customerService.getCustomerById(id);
		// 1.调用Service执行查找逻辑
		flag = customerService.deleteCustomer(customer);
		// 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;

	}
	
	//修改
	public String update() {
		
		boolean flag = false;
		// 1.调用Service执行查找逻辑
		flag = customerService.updateCustomer(cust);
		// 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
	
																				//获取对应的id		//将这个类传到修改页面
	//获取Customer的完整信息，在删除中也调用这个方法里面的逻辑是，但是这个方法是专门为update准备的，运行逻辑是：list.jsp->*Action_findById->edit.jsp->update,在之后的功能模块也是这个逻辑
																							//通过id找到对应的类		//修改数据
	public String findById() {
		// 1.调用Service执行查找逻辑
		Customer customer = customerService.getCustomerById(id);
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", customer);
		// 3.进行页面跳转
		return "update";
	}
	
	//通过姓名查找
	public String findByName() {
		
		boolean flag = false;
		
		// 1.调用Service执行查找逻辑
		List<Customer> list = customerService.getCustomerByName(name);
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", list);
		// 3.将页面跳转到list.jsp页面
		return "list";
	}
	
	//显示所有的信息
	public String list() {
		
		// 1.调用Service执行查找逻辑
		List<Customer> list = customerService.listCustomer();
		// 2.将返回的list对象放入session域
		// ActionContext.getContext().getSession().put("list", list);//这句是有问题的
		ActionContext.getContext().put("list", list);
		// 3.将页面跳转到list.jsp页面
		return "list";
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//使用模型驱动获取对象
	public Customer getModel() {
		return cust;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
