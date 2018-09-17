package com.hmz.service.impl;

import com.hmz.dao.CompanyDao;
import com.hmz.entity.Company;
import com.hmz.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyDao companydao;

    public String querybyname(String com_name) {
        System.out.print(com_name);
        String mes=companydao.querybyname(com_name);
        return mes;

    }
    public String querybyfw(String fw) {
        System.out.print(fw);
        String mes=companydao.querybyfw(fw);
        return mes;
    }
    public String querybygd(String gd) {
        System.out.print(gd);
        String mes=companydao.querybygd(gd);
        return mes;
    }

    public String querybyreg_no(String reg_no) {
        System.out.print("执行service成功");
        System.out.print(reg_no);
        String mes=companydao.queryreg_no(reg_no);
        return mes;
//        return companydao.queryreg_no(reg_no);
    }

    public String querybyperson(String person) {
        System.out.print("执行service成功");
        System.out.print(person);
        String mes= companydao.querybyperson(person);
        return mes;
//        return companydao.queryreg_no(reg_no);
    }

    public String querybypart(String part) {
        System.out.print("执行service成功");
        System.out.print(part);
        String mes= companydao.querybypart(part);
        return mes;
    }

    public String Esubmit(String error) {
        System.out.print("执行service成功");
        String mes= companydao.Esubmit(error);
        return mes;
//        return companydao.queryreg_no(reg_no);
    }

}
