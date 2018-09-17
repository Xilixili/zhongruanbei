package com.hmz.action;

import com.hmz.entity.Company;
import com.hmz.entity.Company1;
import com.hmz.entity.Company2;
import com.hmz.service.CompanyService;
import com.hmz.service.HCompanyService;
import com.hmz.util.SuperAction;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@Scope("prototype")
public class HCompanyAction extends SuperAction {
    JSONObject jsonObject = new JSONObject();
    @Resource//省去再重新声明一个类的步骤
    private HCompanyService HcompanyService;
    private Company1 company1 = new Company1();
//    private JSONObject result;
//    public JSONObject getResult(){
//        return result;
//    }
//    HttpServletRequest request = ServletActionContext.getRequest();
//    HttpServletResponse response = ServletActionContext.getResponse();
private String message0;//年限
private String message1;//资金
private String message2;//有无失信信息
private String message3;//省份
private String message4;//行业
    public String getMessage0() {
        return message0;
    }

    public void setMessage0(String message0) {
        this.message0 = message0;
    }

    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public String getMessage3() {
        return message3;
    }

    public void setMessage3(String message3) {
        this.message3 = message3;
    }

    public String getMessage4() {
        return message4;
    }

    public void setMessage4(String message4) {
        this.message4 = message4;
    }

    public String querybyHsearch() throws IOException {
    //    System.out.println("执行成功了！！！");
    company1.setRQ(message0);
    company1.setZB(message1);
    company1.setPRO(message3);
    company1.setFW(message4);
    System.out.println(message0+","+message1+","+message2+","+message3+","+message4);
    HcompanyService.querybyHsearch(company1);
    return "1";
    }
    //意思是直接把实体类当成页面数据的收集对象,不用再action里面声明getset方法
    //model用来接受表单数据
//    public Company2 getModel() {
//        return company2;
//    }
}
