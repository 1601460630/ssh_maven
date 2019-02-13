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
	//��
	public boolean addLinkMan(LinkMan lkm) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;

		if(lkm.getLkm_name() == null || lkm.getLkm_name().equals(""))
			return flag;
		
		try {
			// ����DAO����ķ���,ִ�����ݿ����
			ld.addLinkMan(lkm);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//ɾ
	public boolean deleteLinkMan(LinkMan lkm) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;
		System.out.println("������Service���е�ͨ��ID���ҷ�����" + lkm);//
		try {
			// ����DAO����ķ���,ִ�����ݿ����
			ld.deleteLinkMan(lkm);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//��
	public boolean updateLinkMan(LinkMan lkm) {
		// ���ó�ʼֵΪfalse
		boolean flag = false;

		try {
			// ����DAO����ķ���,ִ�����ݿ����
			ld.updateLinkMan(lkm);
			// �ɹ��򷵻�true
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ������ȷ�����
		return flag;
	}
	//ͨ��id��
	public LinkMan getLinkManById(Integer id) {
		System.out.println("������Service���е�ͨ��ID���ҷ�����" + id);//
		//ͨ��id���ҿͻ�
		return ld.getBylkmId(id);
	}
	
	public List<LinkMan> getLinkManByName(String name) {
		
		return ld.getBylkmName(name);
	}
	
	//������
	public List<LinkMan> listLinkMan() {
		
		//�������пͻ�		
		return ld.getAllLinkMan();
	}

	
	//��һ���ƺ�����ɾ����û������
	public LinkManDao getld() {
		return ld;
	}

	public void setld(LinkManDao ld) {
		this.ld = ld;
	}

	

}
