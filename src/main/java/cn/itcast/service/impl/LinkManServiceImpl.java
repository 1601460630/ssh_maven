package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class LinkManServiceImpl implements LinkManService {

	private LinkManDao ld;
	//增
	public boolean addLinkMan(LinkMan lkm) {
		// 设置初始值为false
		boolean flag = false;

		if(lkm.getLkm_name() == null || lkm.getLkm_name().equals(""))
			return flag;
		
		try {
			// 调用DAO里面的方法,执行数据库操作
			ld.addLinkMan(lkm);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//删
	public boolean deleteLinkMan(LinkMan lkm) {
		// 设置初始值为false
		boolean flag = false;
		System.out.println("这里是Service层中的通过ID查找方法：" + lkm);//
		try {
			// 调用DAO里面的方法,执行数据库操作
			ld.deleteLinkMan(lkm);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//改
	public boolean updateLinkMan(LinkMan lkm) {
		// 设置初始值为false
		boolean flag = false;

		try {
			// 调用DAO里面的方法,执行数据库操作
			ld.updateLinkMan(lkm);
			// 成功则返回true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回正确或错误
		return flag;
	}
	//通过id查
	public LinkMan getLinkManById(Integer id) {
		System.out.println("这里是Service层中的通过ID查找方法：" + id);//
		//通过id查找客户
		return ld.getBylkmId(id);
	}
	
	public List<LinkMan> getLinkManByName(String name) {
		
		return ld.getBylkmName(name);
	}
	
	//查所有
	public List<LinkMan> listLinkMan() {
		
		//查找所有客户		
		return ld.getAllLinkMan();
	}

	
	//这一段似乎可以删掉，没做测试
	public LinkManDao getld() {
		return ld;
	}

	public void setld(LinkManDao ld) {
		this.ld = ld;
	}

	

}
