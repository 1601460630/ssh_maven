package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.LinkMan;

public interface LinkManService {
	//���ӿͻ�
	boolean addLinkMan(LinkMan lkm);
	//ɾ���ͻ�
	boolean deleteLinkMan(LinkMan lkm);
	//�޸Ŀͻ���Ϣ
	boolean updateLinkMan(LinkMan lkm);
	//ͨ������������ϵ��
	LinkMan getLinkManById(Integer id); 
	//ͨ������������ϵ��
	List<LinkMan> getLinkManByName(String name); 	
	//����������ϵ��
	List<LinkMan> listLinkMan();
	
}
