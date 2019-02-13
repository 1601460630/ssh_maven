package cn.itcast.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Guest;
import cn.itcast.service.GuestService;

//�ݷ��˲���														//ģ������
public class GuestAction extends ActionSupport implements ModelDriven<Guest> {

	private Guest guest = new Guest();
	// ע��Service
	private GuestService guestService;
	
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
	//���������ڲ��Ե�test���֣��������ԣ���ɺ��ɾ��
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
		flag = guestService.addGuest(guest);
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
		Guest guest = guestService.getGuestById(id);
		// 2.����Serviceִ�в����߼�
		flag = guestService.deleteGuest(guest);
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
		flag = guestService.updateGuest(guest);
		// 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
		if (flag == true)
			return SUCCESS;
		else
			return ERROR;
	}
																				//��ȡ��Ӧ��id		//������ഫ���޸�ҳ��
	//��ȡGuest��������Ϣ����ɾ����Ҳ�����������������߼��ǣ��������������ר��Ϊupdate׼���ģ������߼��ǣ�list.jsp->findById->edit.jsp->update
																						//ͨ��id�ҵ���Ӧ����		//�޸�����
	public String findById() {
		
		// 1.����Serviceִ�в����߼�		
		Guest Guest = guestService.getGuestById(id);
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", Guest);
		// 3.����ҳ����ת
		return "update";
	}
	
	//ͨ����������
	public String findByName() {
		
		// 1.����Serviceִ�в����߼�
		List<Guest> list = guestService.getGuestByName(name);
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", list);
		// 3.��ҳ����ת��list.jspҳ��
		return "list";
	}
	
	//��ʾ���е���Ϣ
	public String list() {

		// 1.����Serviceִ�в����߼�
		List<Guest> list = guestService.listGuest();
		// 2.�����ص�list�������session��
		ActionContext.getContext().put("list", list);
		// 3.��ҳ����ת��list.jspҳ��
		return "list";
	}
	
	public void setGuestService(GuestService guestService) {
		this.guestService = guestService;
	}
	//ʹ��ģ��������ȡ����
	public Guest getModel() {
		return guest;
	}


	
	
	
	
	
}
