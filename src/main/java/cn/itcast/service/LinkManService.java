package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.LinkMan;

public interface LinkManService {
	//增加客户
	boolean addLinkMan(LinkMan lkm);
	//删除客户
	boolean deleteLinkMan(LinkMan lkm);
	//修改客户信息
	boolean updateLinkMan(LinkMan lkm);
	//通过姓名查找联系人
	LinkMan getLinkManById(Integer id); 
	//通过姓名查找联系人
	List<LinkMan> getLinkManByName(String name); 	
	//查找所有联系人
	List<LinkMan> listLinkMan();
	
}
