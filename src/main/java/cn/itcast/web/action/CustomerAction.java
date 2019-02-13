package cn.itcast.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Customer;
import cn.itcast.service.CustomerService;
//�ͻ�����																//ģ������
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer cust = new Customer();
	// ע��Service
	private CustomerService customerService;
	
	//����ͨ��set/get��ȡһЩС����
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

	

	// �����ϵ��
	public String add() {

		boolean flag = false;
		// 1.����Serviceִ�в����߼�
		flag = customerService.addCustomer(cust);
		// 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;

	}
	
	//ɾ��
	public String delete() {

		boolean flag = false;
		
		Customer customer = customerService.getCustomerById(id);
		// 1.����Serviceִ�в����߼�
		flag = customerService.deleteCustomer(customer);
		// 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;

	}
	
	//�޸�
	public String update() {
		
		boolean flag = false;
		// 1.����Serviceִ�в����߼�
		flag = customerService.updateCustomer(cust);
		// 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
	
																				//��ȡ��Ӧ��id		//������ഫ���޸�ҳ��
	//��ȡCustomer��������Ϣ����ɾ����Ҳ�����������������߼��ǣ��������������ר��Ϊupdate׼���ģ������߼��ǣ�list.jsp->*Action_findById->edit.jsp->update,��֮��Ĺ���ģ��Ҳ������߼�
																							//ͨ��id�ҵ���Ӧ����		//�޸�����
	public String findById() {
		// 1.����Serviceִ�в����߼�
		Customer customer = customerService.getCustomerById(id);
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", customer);
		// 3.����ҳ����ת
		return "update";
	}
	
	//ͨ����������
	public String findByName() {
		
		boolean flag = false;
		
		// 1.����Serviceִ�в����߼�
		List<Customer> list = customerService.getCustomerByName(name);
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", list);
		// 3.��ҳ����ת��list.jspҳ��
		return "list";
	}
	
	//��ʾ���е���Ϣ
	public String list() {
		
		// 1.����Serviceִ�в����߼�
		List<Customer> list = customerService.listCustomer();
		// 2.�����ص�list�������session��
		// ActionContext.getContext().getSession().put("list", list);//������������
		ActionContext.getContext().put("list", list);
		// 3.��ҳ����ת��list.jspҳ��
		return "list";
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//ʹ��ģ��������ȡ����
	public Customer getModel() {
		return cust;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
