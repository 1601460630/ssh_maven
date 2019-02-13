package cn.itcast.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
//联系人操作															//模型驱动
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan lkm = new LinkMan();
	// 注入Service
	private LinkManService linkManService;
	
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
	//这里是用于测试的test部分，仅供测试，完成后删除
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
		flag = linkManService.addLinkMan(lkm);
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
		LinkMan lkm = linkManService.getLinkManById(id);
		// 2.调用Service执行查找逻辑
		flag = linkManService.deleteLinkMan(lkm);
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
		flag = linkManService.updateLinkMan(lkm);
		// 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
																				//获取对应的id		//将这个类传到修改页面
	//获取LinkMan的完整信息，在删除中也调用这个方法里面的逻辑是，但是这个方法是专门为update准备的，运行逻辑是：list.jsp->findById->edit.jsp->update
																						//通过id找到对应的类		//修改数据
	public String findById() {
		System.out.println("这里是Action层中的通过ID查找方法：" + test);//
		// 1.调用Service执行查找逻辑		
		LinkMan linkMan = linkManService.getLinkManById(id);
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", linkMan);
		// 3.进行页面跳转
		return "update";
	}
	
	//通过姓名查找
	public String findByName() {

		boolean flag = false;
		// 1.调用Service执行查找逻辑
		List<LinkMan> list = linkManService.getLinkManByName(name);
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", list);
		// 3.将页面跳转到list.jsp页面
		return "list";
	}
	
	//显示所有的信息
	public String list() {
		
		// 1.调用Service执行查找逻辑
		List<LinkMan> list = linkManService.listLinkMan();
		// 2.将返回的list对象放入session域
		ActionContext.getContext().put("list", list);
		// 3.将页面跳转到list.jsp页面
		return "list";
	}
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	//使用模型驱动获取对象
	public LinkMan getModel() {
		return lkm;
	}


	
	
	
	
	
}
