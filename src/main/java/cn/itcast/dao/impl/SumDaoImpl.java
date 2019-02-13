package cn.itcast.dao.impl;

import cn.itcast.dao.SumDao;
import cn.itcast.domain.Sum;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.List;

public class SumDaoImpl extends HibernateDaoSupport implements SumDao {

    public List<Sum> sumCustIndustry() {

        try {
            //list1返回的是一个数组
            List list1 = this.getSessionFactory().openSession().createSQLQuery("SELECT count(cust_industry) FROM cst_customer GROUP BY cust_industry").list();
            //list2返回的是一个字符串组
            List list2 = this.getSessionFactory().openSession().createSQLQuery("SELECT cust_industry  FROM cst_customer GROUP BY cust_industry;").list();
            //新建一个list
            List<Sum> sum = new ArrayList<Sum>();
            //将两个数组拼接
            for (int i = 0; i < list1.size(); i++) {
                //新建一个准备好的实体类
                Sum sum1 = new Sum();
                //添加数据
                sum1.setCust_industry(list2.get(i).toString());
                //添加数据，因为是int类型，所以要强转Object->String->int
                sum1.setNum(Integer.parseInt(list1.get(i).toString()));
                sum.add(sum1);
            }
            System.out.println("这里是DAO层，sum = " + sum);
            return sum;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
