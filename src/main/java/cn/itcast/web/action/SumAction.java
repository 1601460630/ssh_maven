package cn.itcast.web.action;

import cn.itcast.service.SumService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
//��ҵͳ��
public class SumAction extends ActionSupport {

    private SumService sumService;

    public void setSumService(SumService sumService) {
        this.sumService = sumService;
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

    public String sumCust(){
        //ִ���߼�
        List list = sumService.sumCustIndustry();
        System.out.println("������Action�㣬list = " + list);
        //�ŵ�session�����
        ActionContext.getContext().put("list", list);
        //�����ҳ��
        return "sum";
    }
}
