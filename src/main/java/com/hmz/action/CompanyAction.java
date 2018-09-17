package com.hmz.action;

import com.hmz.entity.Company;
import com.hmz.entity.Company2;
import com.hmz.service.CompanyService;
import com.hmz.util.SuperAction;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@Scope("prototype")
public class CompanyAction extends SuperAction implements ModelDriven<Company2> {
    JSONObject jsonObject = new JSONObject();
    @Resource//省去再重新声明一个类的步骤
    private CompanyService companyService;
    private Company2 company2 = new Company2();
    private JSONObject result;
    public JSONObject getResult(){
        return result;
    }
String mes="E2";
    //根据法人高管查询
    public String querybyperson() throws IOException {
        System.out.print("执行comaction成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的person值为"+ company2.getCom_name());
        if (company2.getCom_name().contains("||---------------||")){
            String person=company2.getCom_name().split("\\|\\|")[2].split(":")[1];
             mes=companyService.querybyperson(person);
        }else {
            String person=company2.getCom_name();
             mes=companyService.querybyperson(person);
        }
////        out.print(company2.toString());
//        out.flush();
//        out.close();
//        System.out.println(mes);
        if (mes.equals("error")){
            return "E2";
        }
        else {return "1";}
    }


    //根据股东查询
    public String querybygd() throws IOException {
        System.out.print("执行comaction成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的person值为"+ company2.getCom_name());
        String mes=companyService.querybygd(company2.getCom_name());
////        out.print(company2.toString());
//        out.flush();
//        out.close();
        System.out.println(mes);
        if (mes.equals("error")){
            return "E2";
        }
        else {return "1";}
    }

    //根据经营范围查询
    public String querybypart() throws IOException {
        System.out.print("执行comaction成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的part值为"+ company2.getCom_name());
        String mes=companyService.querybypart(company2.getCom_name());

        System.out.println(mes);
        if (mes.equals("error")){
            return "E2";
        }
        else {return "11";}
    }


//根据注册号查询
    public String querybyreg_no() throws IOException {
        System.out.print("执行comaction成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的reg_no值为"+ company2.getCom_name());
        String mes=companyService.querybyreg_no(company2.getCom_name());

        System.out.println(mes);
        if (mes.equals("error")){
            return "E2";
        }
        else {return "1";}
    }
    //根据注册号查询
    public String querybyall() throws IOException {
        System.out.print("执行comaction成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的reg_no值为"+ company2.getCom_name());
        String mes=companyService.querybyname(company2.getCom_name());
        System.out.println(mes);
        if (mes.equals("error")){
            mes=companyService.querybyreg_no(company2.getCom_name());
            if (mes.equals("error")){
                mes=companyService.querybyperson(company2.getCom_name());
                if (mes.equals("error")){
                    mes=companyService.querybygd(company2.getCom_name());
                    if (mes.equals("error")){
                        mes=companyService.querybyfw(company2.getCom_name());
                    }
                }
            }
        }else {
            return "1";
        }

        if (mes.equals("error")){
            return "E2";
        } else {return "1";}
    }

    //根据公司名字查询
    public String querybyname() throws IOException {
        System.out.print("执行queryname成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
//        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的name值为"+company2.getCom_name());
        ServletActionContext.getRequest().getSession().setAttribute("com_name",company2.getCom_name());
        String mes=companyService.querybyname(company2.getCom_name());

//        out.print(company2.toString());
//        out.flush();
//        out.close();
        System.out.println(mes);
        if (mes.equals("error")){
            return "error";
        }
        else {return "1";}
    }

    public String querybyfw() throws IOException {
        System.out.print("执行querybyfw成功");
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
//        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的fw值为"+company2.getCom_name());

        ServletActionContext.getRequest().getSession().setAttribute("com_name",company2.getCom_name());
        String mes=companyService.querybyfw(company2.getCom_name());

//        out.print(company2.toString());
//        out.flush();
//        out.close();
        System.out.println(mes);
        if (mes.equals("error")){
            return "E2";
        }
        else {return "1";}
    }
//错误信息（缺失的信息）的提交
    public String Esubmit() throws IOException {
        ServletActionContext.getResponse().setContentType ("text/html;charset=utf-8");
//        PrintWriter out = ServletActionContext.getResponse().getWriter();
        System.out.print("传过来的Error值为"+company2.getCom_name());

        ServletActionContext.getRequest().getSession().setAttribute("com_name",company2.getCom_name());
        String mes=companyService.Esubmit(company2.getCom_name());
        return "E";
    }


    //意思是直接把实体类当成页面数据的收集对象,不用再action里面声明getset方法
    //model用来接受表单数据
    public Company2 getModel() {
        return company2;
    }
}
