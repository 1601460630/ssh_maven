package cn.itcast.web.action;

import java.util.List;

import cn.itcast.service.CustomerService;
import cn.itcast.service.GuestService;
import cn.itcast.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.*;
import cn.itcast.service.ComplexService;
//�ۺϲ�ѯ�����ǿͻ�����ϵ�ˡ��ݷ���������ѯ���ܺ�
public class ComplexAction extends ActionSupport {
    //���ģ�����ҳ���е�name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //����ͨ��springע��������Service,����spring�������ļ��У�����ComplexActionʱ��������<property></property>
    private CustomerService customerService;
    private GuestService guestService;
    private LinkManService linkManService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setGuestService(GuestService guestService) {
        this.guestService = guestService;
    }

    public void setLinkManService(LinkManService linkManService) {
        this.linkManService = linkManService;
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

    // ͨ���������ҿͻ�
    public String findCust() {
        // 1.����Serviceִ�в����߼�
        List<Customer> list = customerService.getCustomerByName(name);
        // 2.�����ص�list�������session��
        ActionContext.getContext().put("list", list);
        // 3.��ҳ����ת��list.jspҳ��
        return "cust";
    }

    // ͨ������������ϵ��
    public String findLkm() {

        // 1.����Serviceִ�в����߼�
        List<LinkMan> list = linkManService.getLinkManByName(name);
        // 2.�����ص�list�������session��
        ActionContext.getContext().put("list", list);
        // 3.��ҳ����ת��list.jspҳ��
        return "lkm";
    }

    // ͨ���������Ұݷ���
    public String findGuest() {

        // 1.����Serviceִ�в����߼�
        List<Guest> list = guestService.getGuestByName(name);
        // 2.�����ص�list�������session��
        ActionContext.getContext().put("list", list);
        // 3.��ҳ����ת��list.jspҳ��
        return "guest";
    }

}
