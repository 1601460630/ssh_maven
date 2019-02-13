package cn.itcast.web.action;

import java.util.List;

import cn.itcast.service.CustomerService;
import cn.itcast.service.GuestService;
import cn.itcast.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.*;
import cn.itcast.service.ComplexService;
//综合查询，就是客户、联系人、拜访人三个查询的总和
public class ComplexAction extends ActionSupport {
    //核心：接收页面中的name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //这里通过spring注入了三个Service,所以spring的配置文件中，配置ComplexAction时用了三个<property></property>
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
    //这里是用于测试的test部分，仅供测试，完成后删除
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    //-----------------------------------------------------------------------

    // 通过姓名查找客户
    public String findCust() {
        // 1.调用Service执行查找逻辑
        List<Customer> list = customerService.getCustomerByName(name);
        // 2.将返回的list对象放入session域
        ActionContext.getContext().put("list", list);
        // 3.将页面跳转到list.jsp页面
        return "cust";
    }

    // 通过姓名查找联系人
    public String findLkm() {

        // 1.调用Service执行查找逻辑
        List<LinkMan> list = linkManService.getLinkManByName(name);
        // 2.将返回的list对象放入session域
        ActionContext.getContext().put("list", list);
        // 3.将页面跳转到list.jsp页面
        return "lkm";
    }

    // 通过姓名查找拜访人
    public String findGuest() {

        // 1.调用Service执行查找逻辑
        List<Guest> list = guestService.getGuestByName(name);
        // 2.将返回的list对象放入session域
        ActionContext.getContext().put("list", list);
        // 3.将页面跳转到list.jsp页面
        return "guest";
    }

}
