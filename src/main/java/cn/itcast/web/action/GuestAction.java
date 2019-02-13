package cn.itcast.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Guest;
import cn.itcast.service.GuestService;

//拜访人操作														//模型驱动
public class GuestAction extends ActionSupport implements ModelDriven<Guest> {

	private Guest guest = new Guest();
	// 注入Service
	private GuestService guestService;
	
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

	//-----------------------------------------------------------------------
	//这里是用于测试的test部分，仅供测试，完成后可删除
	private String test;
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	//-----------------------------------------------------------------------

	//添加
	public String add() {
		
		boolean flag = false;
		// 1.调用Service执行查找逻辑
		flag = guestService.addGuest(guest);
		// 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
	
	//删除
	public String delete() {
		
		boolean flag = false;
		// 1.调用Service，通过获取到的id查找对应的类
		Guest guest = guestService.getGuestById(id);
		// 2.调用Service执行查找逻辑
		flag = guestService.deleteGuest(guest);
		// 3.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;

	}
	
	//修改
	public String update() {
		
		boolean flag = false;
		// 1.调用Service执行查找逻辑
		flag = guestService.updateGuest(guest);
		// 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
																				//获取对应的id		//将这个类传到修改页面
	//获取Guest的完整信息，在删除中也调用这个方法里面的逻辑是，但是这个方法是专门为update准备的，运行逻辑是：list.jsp->findById->edit.jsp->update
																						//通过id找到对应的类		//修改数据
	public String findById() {
		
		// 1.调用Service执行查找逻辑		
		Guest Guest = guestService.getGuestById(id);
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", Guest);
		// 3.进行页面跳转
		return "update";
	}
	
	//通过姓名查找
	public String findByName() {
		
		// 1.调用Service执行查找逻辑
		List<Guest> list = guestService.getGuestByName(name);
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", list);
		// 3.将页面跳转到list.jsp页面
		return "list";
	}
	
	//显示所有的信息
	public String list() {

		// 1.调用Service执行查找逻辑
		List<Guest> list = guestService.listGuest();
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", list);
		// 3.将页面跳转到list.jsp页面
		return "list";
	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	//使用模型驱动获取对象
	public Guest getModel() {
		return guest;
	}


	
	
	
	
	
}
