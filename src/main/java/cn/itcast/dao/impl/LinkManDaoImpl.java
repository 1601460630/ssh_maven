package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.LinkMan;

//HibernateDaoSupportΪdaoע��sessionFactory
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	// ������ϵ��
	public void addLinkMan(LinkMan lkm) {

		this.getHibernateTemplate().save(lkm);
	}

	// ɾ����ϵ��
	public void deleteLinkMan(LinkMan lkm) {
		
		this.getHibernateTemplate().delete(lkm);
	}

	// �޸���ϵ����Ϣ
	public void updateLinkMan(LinkMan lkm) {
		
		this.getHibernateTemplate().update(lkm);
	}

	// ͨ�� id ������ϵ��
	public LinkMan getBylkmId(Integer lkm_id) {
		System.out.println("������DAO���е�ͨ��ID���ҷ�����" + lkm_id);//
		List<LinkMan> list = null;
		try {
			list = (List<LinkMan>) this.getHibernateTemplate().find(" from LinkMan where lkm_id = ? ",lkm_id);
			System.out.println("������DAO���е�ͨ��ID���ҷ�����ȡ���Ľ����" + list.get(0));//
		} catch (Exception e) {
			System.out.println("�������");
			e.printStackTrace();
		}

		return list.get(0);
	}

	// ͨ�� ���� ������ϵ��
	public List<LinkMan> getBylkmName(String lkm_name) {
		
		return (List<LinkMan>) this.getHibernateTemplate().find(" from LinkMan where lkm_name = ? ", lkm_name);
	}

	// ����������ϵ��
	public List<LinkMan> getAllLinkMan() {

		return (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
	}

}
