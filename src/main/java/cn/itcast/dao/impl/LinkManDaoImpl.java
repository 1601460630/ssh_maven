package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;

//HibernateDaoSupport为dao注入sessionFactory
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	// 增加联系人
	public void addLinkMan(LinkMan lkm) {

		this.getHibernateTemplate().save(lkm);
	}

	// 删除联系人
	public void deleteLinkMan(LinkMan lkm) {
		
		this.getHibernateTemplate().delete(lkm);
	}

	// 修改联系人信息
	public void updateLinkMan(LinkMan lkm) {
		
		this.getHibernateTemplate().update(lkm);
	}

	// 通过 id 查找联系人
	public LinkMan getBylkmId(Integer lkm_id) {
		System.out.println("这里是DAO层中的通过ID查找方法：" + lkm_id);//
		List<LinkMan> list = null;
		try {
			list = (List<LinkMan>) this.getHibernateTemplate().find(" from LinkMan where lkm_id = ? ",lkm_id);
			System.out.println("这里是DAO层中的通过ID查找方法获取到的结果：" + list.get(0));//
		} catch (Exception e) {
			System.out.println("这里错了");
			e.printStackTrace();
		}

		return list.get(0);
	}

	// 通过 姓名 查找联系人
	public List<LinkMan> getBylkmName(String lkm_name) {
		
		return (List<LinkMan>) this.getHibernateTemplate().find(" from LinkMan where lkm_name = ? ", lkm_name);
	}

	// 查找所有联系人
	public List<LinkMan> getAllLinkMan() {

		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

}
