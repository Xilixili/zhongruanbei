package com.hmz.action;
import com.hmz.entity.User;
import com.hmz.service.UserService;
import com.hmz.util.SuperAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/9/8.
 */
@Controller
@Scope("prototype")
//指定Bean实例的作用域。
public class UserAction extends SuperAction implements ModelDriven<User>{
    JSONObject jsonObject = new JSONObject();
    @Resource//省去再重新声明一个类的步骤
    private UserService userService;
    private User user = new User();
    private JSONObject result;
    public JSONObject getResult(){
        return result;
    }
    public String login() {
        System.out.print("执行login成功");
        System.out.println(user.toString());
        boolean login = userService.login(user);
        if (login) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();

            session.put("user_name",user.getUsername());

            return "success";
        }
        else{
            Map<String,Object> jsonmap=new HashMap<String, Object>();
            jsonmap.put("result","fail");
            result=JSONObject.fromObject(jsonmap);
            return "fail";
        }
    }
    //注册
    public String add(){
        System.out.println("进入action的add语句");
        System.out.println(user.toString());
        userService.add(user);
        return "add_success";
    }
    public String changeXinxi(){
        System.out.println("进入action的changeXinxi语句");
        System.out.println("user wei"+user.toString());
        userService.changeXinxi(user);
        return "changeXinxi_success";
    }
    public String DeleteGZ(){
        System.out.println("进入GuanZhu的add语句");
        String username=request.getSession().getAttribute("user_name").toString();
        user.setUsername(username);
        System.out.println(user.toString());
        userService.GuanZhu(user);
        return "add_success";
    }

    public String note(){
        System.out.println("进入action的note语句");
        System.out.println(user.toString());
        userService.note(user);
        return "add_success";
    }
    //登出
    public User getModel() {
        return user;
    }
}
