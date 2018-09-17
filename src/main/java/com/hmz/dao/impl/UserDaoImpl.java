package com.hmz.dao.impl;

import com.hmz.dao.UserDao;
import com.hmz.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.util.List;

/**
 * @Author Hu mingzhi
 * Created by ThinKPad on 2017/9/8.
 */
@Repository
//dao组件
//userdao的实现类
public class UserDaoImpl implements UserDao{


    private HibernateTemplate template;
//由于hiberanteTemplate已经由Spring注入，所以直接调用HibernateTemplate类的save()方法即可。
    @Resource(name="hibernateTemplate")

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    public boolean login(User user) {
        System.out.print(user.toString());
        String hql = "from User u where u.username = ? and u.password = ?";
        //填充上一步的两个参数
         List<User>  userList = (List<User>) this.template.find(hql, new Object[]{user.getUsername(),user.getPassword()});
         System.out.print(userList.size());
        if (userList.size() > 0) {
            return true;
        }else
            System.out.println("用户登录失败"+user.toString());
            return false;
    }

    public  List<User> queryAll() {
        String hql = "from User";
        List<User> userList = (List<User>) this.template.find(hql);
        return userList;
    }
//id delete
    public boolean delete(int id) {
        int i = this.template.bulkUpdate("delete from User where id=" + id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public void add(User user) {
        System.out.println("进入dao的add语句");
        System.out.println(user.toString());
        this.template.save(user);
    }
    public void note(User user) {
        System.out.println("进入dao的add语句");
        System.out.println(user.toString());
        this.template.save(user);
    }

    public void GuanZhu(User user) {

//        System.out.println("进入dao的add语句");
        System.out.println(user.toString());
        Connection conn = null;
        PreparedStatement stmt1 = null;
        String sql1 = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            sql1=" delete from gz where GZ_com=? and username=?";

            stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, user.getCom());
            stmt1.setString(2, user.getUsername());
            stmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //改变用户的基本信息

    public void changeXinxi(User user) {
        String hql = "from User u where u.username = ?";
        //填充上一步的两个参数
        Connection conn = null;
        PreparedStatement stmt1 = null;
        String sql1 = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&characterEncoding=utf-8");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            sql1="update user1 set sex=?,com=?,FW=?,Uposition=?,Addr=?,Tname=? where username=?";

        stmt1 = conn.prepareStatement(sql1);
        stmt1.setString(1, user.getSex());
        stmt1.setString(2, user.getCom());
        stmt1.setString(3, user.getFW());
        stmt1.setString(4, user.getUposition());
        stmt1.setString(5, user.getAddr());
        stmt1.setString(6, user.getTname());
        stmt1.setString(7, user.getUsername());
        stmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("进入dao的changeXinxi语句");
        System.out.println(user.toString());

    }

    public User queryOne(Integer id) {
        List<User> userList = (List<User>) this.template.find("from User u where u.id = ?", new Integer(id));
        User user = userList.get(0);
        return user;
    }

    public void updateOne(User user) {
        this.template.update(user);
    }
}
