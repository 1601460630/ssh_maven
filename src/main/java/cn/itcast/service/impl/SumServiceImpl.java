package cn.itcast.service.impl;

import cn.itcast.dao.SumDao;
import cn.itcast.domain.Sum;
import cn.itcast.service.SumService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class SumServiceImpl implements SumService {

    private SumDao sd;

    public SumDao getSd() {
        return sd;
    }

    public void setSd(SumDao sd) {
        this.sd = sd;
    }

    public List<Sum> sumCustIndustry() {

        return sd.sumCustIndustry();
    }
}
