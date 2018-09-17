package com.hmz.service.impl;

import com.hmz.dao.CompanyDao;
import com.hmz.dao.HCompanyDao;
import com.hmz.entity.Company;
import com.hmz.entity.Company1;
import com.hmz.service.HCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class HCompanyServiceImpl implements HCompanyService {
    @Resource
    private HCompanyDao Hcompanydao;
    public void querybyHsearch(Company1 company1) {
        System.out.println("执行了service成功");
        Hcompanydao.querybyHsearch(company1);
    }
}
