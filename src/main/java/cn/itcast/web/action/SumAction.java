package cn.itcast.web.action;

import cn.itcast.service.SumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
//行业统计
public class SumAction extends ActionSupport {

    private SumService sumService;

    public void setSumService(SumService sumService) {
        this.sumService = sumService;
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

    public String sumCust(){
        //执行逻辑
        List list = sumService.sumCustIndustry();
        System.out.println("这里是Action层，list = " + list);
        //放到session中输出
        ActionContext.getContext().put("list", list);
        //输出到页面
        return "sum";
    }
}
