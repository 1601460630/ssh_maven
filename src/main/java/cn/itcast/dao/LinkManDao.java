package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.LinkMan;

public interface LinkManDao {
	
	//������ϵ��
	void addLinkMan(LinkMan lkm);
	//ɾ����ϵ��
	void deleteLinkMan(LinkMan lkm);
	//�޸���ϵ����Ϣ
	void updateLinkMan(LinkMan lkm);
	//ͨ��id������ϵ��
	LinkMan getBylkmId(Integer lkm_id);
	//ͨ������������ϵ��
	List<LinkMan> getBylkmName(String lkm_name);
	//����������ϵ��
	List<LinkMan> getAllLinkMan();

}
