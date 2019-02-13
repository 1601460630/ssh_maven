package cn.itcast.dao;

import cn.itcast.domain.Sum;

import java.util.List;

public interface SumDao {

    //客户行业统计
    List<Sum> sumCustIndustry();
}
