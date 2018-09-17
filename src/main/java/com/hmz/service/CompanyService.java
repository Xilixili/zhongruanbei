package com.hmz.service;

import com.hmz.entity.Company;
import com.hmz.entity.Company2;

public interface CompanyService {
    public String querybyname(String com_name);
    public String querybyfw(String fw);
    public String querybygd(String gd);
    public String querybyreg_no(String reg_no);
    public String querybyperson(String person);
    public String Esubmit(String error);
    public String querybypart(String part);
}
