package cn.itcast.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.LinkMan;
import cn.itcast.service.LinkManService;
//��ϵ�˲���															//ģ������
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan lkm = new LinkMan();
	// ע��Service
	private LinkManService linkManService;
	
	//����ͨ��set/get��ȡһЩС����
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
	//���������ڲ��Ե�test���֣��������ԣ���ɺ�ɾ��
	private String test;
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	//-----------------------------------------------------------------------
	
	

	//���
	public String add() {

		boolean flag = false;
		// 1.����Serviceִ�в����߼�
		flag = linkManService.addLinkMan(lkm);
		// 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
	
	//ɾ��
	public String delete() {
		boolean flag = false;
		// 1.����Service��ͨ����ȡ����id���Ҷ�Ӧ����
		LinkMan lkm = linkManService.getLinkManById(id);
		// 2.����Serviceִ�в����߼�
		flag = linkManService.deleteLinkMan(lkm);
		// 3.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;

	}
	
	//�޸�
	public String update() {
		
		boolean flag = false;
		// 1.����Serviceִ�в����߼�
		flag = linkManService.updateLinkMan(lkm);
		// 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
																				//��ȡ��Ӧ��id		//������ഫ���޸�ҳ��
	//��ȡLinkMan��������Ϣ����ɾ����Ҳ�����������������߼��ǣ��������������ר��Ϊupdate׼���ģ������߼��ǣ�list.jsp->findById->edit.jsp->update
																						//ͨ��id�ҵ���Ӧ����		//�޸�����
	public String findById() {
		System.out.println("������Action���е�ͨ��ID���ҷ�����" + test);//
		// 1.����Serviceִ�в����߼�		
		LinkMan linkMan = linkManService.getLinkManById(id);
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", linkMan);
		// 3.����ҳ����ת
		return "update";
	}
	
	//ͨ����������
	public String findByName() {

		boolean flag = false;
		// 1.����Serviceִ�в����߼�
		List<LinkMan> list = linkManService.getLinkManByName(name);
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", list);
		// 3.��ҳ����ת��list.jspҳ��
		return "list";
	}
	
	//��ʾ���е���Ϣ
	public String list() {
		
		// 1.����Serviceִ�в����߼�
		List<LinkMan> list = linkManService.listLinkMan();
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", list);
		// 3.��ҳ����ת��list.jspҳ��
		return "list";
	}
	
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	//ʹ��ģ��������ȡ����
	public LinkMan getModel() {
		return lkm;
	}


	
	
	
	
	
}
