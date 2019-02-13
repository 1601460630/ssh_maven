package cn.itcast.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;


@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
public class UserServiceImpl implements UserService {

    private UserDao ud;

    //逻辑重构，转到了Action层
    //其实两个错误的抛出的提示应该都是  用户名或密码错误
    //可以覆盖上面的那段注释，但仅对下面这一个方法有效
    /*@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByCodePassword(User u) {
        //1.根据登录名称查询登录用户
        User existU = ud.getByUserCode(u.getUser_code());
        //2.判断登录用户是否存在,不存在=>抛出异常,提示用户名不存在
        if (existU == null) {
            throw new RuntimeException("用户名不存在！");
        }
        //3.判断用户名密码是否正确,不正确=>抛出异常,提示密码错误
        if (!existU.getUser_password().equals(u.getUser_password())) {
            throw new RuntimeException("密码错误！");
        }
        //4.返回查询到的用户对象

        return existU;
    }*/

    public boolean saveUser(User u) {
        // 设置初始值为false
        boolean flag = false;

        try {
            // 调用DAO里面的方法,执行数据库操作
            ud.addUser(u);
            // 成功则返回true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回正确或错误
        return flag;
    }

    public boolean deleteUser(User u) {
        // 设置初始值为false
        boolean flag = false;
        try {
            // 调用DAO里面的方法,执行数据库操作
            ud.deleteUser(u);
            // 成功则返回true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回正确或错误
        return flag;
    }

    public boolean updateUser(User u) {
        // 设置初始值为false
        boolean flag = false;

        try {
            // 调用DAO里面的方法,执行数据库操作
            ud.updateUser(u);
            // 成功则返回true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回正确或错误
        return flag;
    }


    //查所有
    public List<User> list() {

        return ud.list();
    }

    //通过用户名查找用户
    public User findByCode(String code) {
        //由于list为空时，list.get(0)会报错，所以做了如下处理，这么做的前提是默认数据库中不存在重复的用户名
        if (ud.findByCode(code).size() == 1)
            return ud.findByCode(code).get(0);
        else
            return null;
    }

    //通过姓名查找用户
    public List<User> findByName(String name) {

        return ud.findByName(name);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }


}
