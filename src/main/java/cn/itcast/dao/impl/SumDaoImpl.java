package cn.itcast.dao.impl;

import cn.itcast.dao.SumDao;
import cn.itcast.domain.Sum;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class SumDaoImpl extends HibernateDaoSupport implements SumDao {

    public List<Sum> sumCustIndustry() {

        try {
            //list1���ص���һ������
            List list1 = this.getSessionFactory().openSession().createSQLQuery("SELECT count(cust_industry) FROM cst_customer GROUP BY cust_industry").list();
            //list2���ص���һ���ַ�����
            List list2 = this.getSessionFactory().openSession().createSQLQuery("SELECT cust_industry  FROM cst_customer GROUP BY cust_industry;").list();
            //�½�һ��list
            List<Sum> sum = new ArrayList<Sum>();
            //����������ƴ��
            for (int i = 0; i < list1.size(); i++) {
                //�½�һ��׼���õ�ʵ����
                Sum sum1 = new Sum();
                //�������
                sum1.setCust_industry(list2.get(i).toString());
                //������ݣ���Ϊ��int���ͣ�����ҪǿתObject->String->int
                sum1.setNum(Integer.parseInt(list1.get(i).toString()));
                sum.add(sum1);
            }
            System.out.println("������DAO�㣬sum = " + sum);
            return sum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
