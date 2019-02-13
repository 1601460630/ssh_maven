package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.LinkMan;

public interface LinkManDao {
	
	//增加联系人
	void addLinkMan(LinkMan lkm);
	//删除联系人
	void deleteLinkMan(LinkMan lkm);
	//修改联系人信息
	void updateLinkMan(LinkMan lkm);
	//通过id查找联系人
	LinkMan getBylkmId(Integer lkm_id);
	//通过姓名查找联系人
	List<LinkMan> getBylkmName(String lkm_name);
	//查找所有联系人
	List<LinkMan> getAllLinkMan();

}
