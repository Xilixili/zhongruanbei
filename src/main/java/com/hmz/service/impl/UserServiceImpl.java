package com.hmz.service.impl;

import com.hmz.dao.UserDao;
import com.hmz.entity.User;
import com.hmz.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/9/8.
 */
//userservice的实现类
//@Service，用于标注业务层组件（通常定义的 Service 层就用这个注解）；
//@Controller，用于标注控制层组件（如 Struts 中的 action）；
//@Repository，用于标注数据访问组件，即 DAO 层组件；
//@Component，泛指组件，当组件不好归类的时候，咱们就可以用这个注解进行标注。
//该类是针对dao中的一些具体的操作：登陆操作  用户查找操作 删除操作  添加操作  查找一个   修改一个的操作
//定义为bean类在这里，@Service(“XXX”)，就相当于将这个类定义为一个 bean，其中，XXX 即为 bean 的名称。此外，咱们只用此注解标记 bean，如果不填 value 的话，则 Spring 生成的 bean 名称是取类名，然后将首字母小写。
@Service

public class UserServiceImpl implements UserService {
    //在类中需要定义一个属性，并且该属性是一个已经存在的bean，在为给属性赋值或注入时，就需要在给属性上一行加一个@resourc注解
    @Resource
    private UserDao userDao;

//用户登录
    public boolean login(User user) {
        boolean login = userDao.login(user);
        if (login) {
            return true;
        } else
            return false;
    }
//查询所有用户，计划管理员可用
    public List<User> queryAll() {

        return userDao.queryAll();

    }
//根据id删除用户
    public boolean delete(int id) {
        boolean delete = userDao.delete(id);
        if (delete) {
            return true;
        }
        return false;
    }
//添加用户
    public void add(User user) {
        System.out.println("进入service的add语句");
        System.out.println(user.toString());
        userDao.add(user);

    }
    public void note(User user) {
        System.out.println("进入service的note语句");
        System.out.println(user.toString());
        userDao.note(user);

    }
    public void GuanZhu(User user) {
        System.out.println("进入service的GuanZhu语句");
        System.out.println(user.toString());
        userDao.GuanZhu(user);

    }
    public void changeXinxi(User user) {
        System.out.println("进入service的changeXinxi语句");
        System.out.println(user.toString());
        userDao.changeXinxi(user);
    }
//根据id查询用户
    public User queryOne(Integer id) {
        return userDao.queryOne(id);
    }
//更新某个用户的信息
    public void updateOne(User user) {
        userDao.updateOne(user);

    }
}
