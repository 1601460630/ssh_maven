package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

//用户操作
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    //注入Service
    private UserService userService;
    //接收确认密码
    private String user_password2;

    public String getUser_password2() {
        return user_password2;
    }

    public void setUser_password2(String user_password2) {
        this.user_password2 = user_password2;
    }

    //-----------------------------------------------------------------------
    //这里是用于测试的test部分，仅供测试，完成后可删除
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    //-----------------------------------------------------------------------
    //登录
    /*public String login() {
        boolean flag = false;
        //1.调用Service执行登录逻辑
        User u = userService.getUserByCodePassword(user);
        //如果是超级用户，跳转到不同页面
        if (u.getUser_code().equals("admin"))
            flag = true;
        //2.将返回的User对象放入session域
        ActionContext.getContext().put("user", u);
        //3.根据用户情况跳转到项目首页
        if (flag == true)
            return "toAdmin";
        else
            return "toUser";
    }*/
    //登录?改
    public String login() {

        boolean flag = false;
        //1.判断用户名和密码是否输入
        if (user.getUser_code().equals("") || user.getUser_password().equals("")) {
            addActionError("用户名或密码为空");
            return "loginError";
        }
        //2.判断用户名是否存在
        else if (userService.findByCode(user.getUser_code()) == null) {
            addActionError("用户名不存在");
            return "loginError";
        }
        //3.判断用户名和密码是否正确
        else if (userService.findByCode(user.getUser_code()).getUser_password().equals(user.getUser_password()) == false) {
            addActionError("用户名或密码不正确");
            return "loginError";
        }
        //4.判断是不是超级用户
        else if (user.getUser_code().equals("admin")) {
            flag = true;
        }
        //5.不是超级用户
        else
            flag = false;
        //根据用户情况跳转到对应页面
        if (flag == true)
            return "toAdmin";
        else
            return "toUser";
    }

    //增
    public String save() {

        boolean flag = false;
        //1.对输入判断
        if (user.getUser_password().equals(user_password2) == false) {
            //（1）若两个密码不一样不一样，输出错误信息
            addActionError("两次密码不一致");
            return "addError";
        } else if (user.getUser_code().equals("") || user.getUser_password().equals("")) {
            //（2）若用户名或密码为空
            addActionError("缺少重要信息");
            return "addError";
        } else {
            //（3）调用Service执行查找逻辑
            flag = userService.saveUser(user);
        }

        // 2.视情况返回对应参数，个人认为，在实际上线之后不应该有error这个选项（因为上线之后不应该出现错误）
        if (flag == true)
            return "login";//跳回到登录界面
        else
            return ERROR;
    }

    //删
    public String delete() {

        boolean flag = false;
        // 1.获取这个用户
        User user1 = userService.findByCode(user.getUser_code());
        // 2.调用Service执行查找逻辑
        flag = userService.deleteUser(user1);
        // 3.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
        if (flag == true)
            return SUCCESS;
        else
            return ERROR;
    }

    //改
    public String update() {

        boolean flag = false;
        // 1.调用Service执行查找逻辑
        flag = userService.updateUser(user);
        // 2.视情况返回对应参数，其实在实际上线之后不应该有error这个选项
        if (flag == true)
            return SUCCESS;
        else
            return ERROR;
    }

    //查所有
    public String list() {
        // 1.调用Service执行查找逻辑
        List<User> list = userService.list();
        // 2.将返回的list对象放入session域
        ActionContext.getContext().put("list", list);
        // 3.将页面跳转到list.jsp页面
        return "list";
    }

    //通过用户名查
    public String findByCode() {
        // 1.调用Service执行查找逻辑
        user = userService.findByCode(user.getUser_code());
        // 2.将返回的list对象放入session域
        ActionContext.getContext().put("list", user);
        // 3.进行页面跳转
        return "update";
    }

    //通过姓名查找
    public String findByName() {
        // 1.调用Service执行查找逻辑
        List<User> list = userService.findByName(user.getUser_name());
        // 2.将返回的list对象放入session域
        ActionContext.getContext().put("list", list);
        // 3.进行页面跳转
        return "list";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //使用模型驱动获取对象
    public User getModel() {
        return user;
    }


}
