package com.hmz.dao;
import com.hmz.entity.Company;
import com.hmz.entity.Company2;

import java.util.ArrayList;

public interface CompanyDao {
    public String querybyname(String com_name);
    public String querybyfw(String fw);
    public String querybygd(String gd);
    public String queryreg_no(String reg_no);
    public String querybyperson(String person);
    public String querybypart(String part);
    public String Esubmit(String error);
    public ArrayList<Company2> getAll();
}
