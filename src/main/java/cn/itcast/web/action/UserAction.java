package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;

//�û�����
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    //ע��Service
    private UserService userService;
    //����ȷ������
    private String user_password2;

    public String getUser_password2() {
        return user_password2;
    }

    public void setUser_password2(String user_password2) {
        this.user_password2 = user_password2;
    }

    //-----------------------------------------------------------------------
    //���������ڲ��Ե�test���֣��������ԣ���ɺ��ɾ��
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    //-----------------------------------------------------------------------
    //��¼
    /*public String login() {
        boolean flag = false;
        //1.����Serviceִ�е�¼�߼�
        User u = userService.getUserByCodePassword(user);
        //����ǳ����û�����ת����ͬҳ��
        if (u.getUser_code().equals("admin"))
            flag = true;
        //2.�����ص�User�������session��
        ActionContext.getContext().put("user", u);
        //3.�����û������ת����Ŀ��ҳ
        if (flag == true)
            return "toAdmin";
        else
            return "toUser";
    }*/
    //��¼?��
    public String login() {

        boolean flag = false;
        //1.�ж��û����������Ƿ�����
        if (user.getUser_code().equals("") || user.getUser_password().equals("")) {
            addActionError("�û���������Ϊ��");
            return "loginError";
        }
        //2.�ж��û����Ƿ����
        else if (userService.findByCode(user.getUser_code()) == null) {
            addActionError("�û���������");
            return "loginError";
        }
        //3.�ж��û����������Ƿ���ȷ
        else if (userService.findByCode(user.getUser_code()).getUser_password().equals(user.getUser_password()) == false) {
            addActionError("�û��������벻��ȷ");
            return "loginError";
        }
        //4.�ж��ǲ��ǳ����û�
        else if (user.getUser_code().equals("admin")) {
            flag = true;
        }
        //5.���ǳ����û�
        else
            flag = false;
        //�����û������ת����Ӧҳ��
        if (flag == true)
            return "toAdmin";
        else
            return "toUser";
    }

    //��
    public String save() {

        boolean flag = false;
        //1.�������ж�
        if (user.getUser_password().equals(user_password2) == false) {
            //��1�����������벻һ����һ�������������Ϣ
            addActionError("�������벻һ��");
            return "addError";
        } else if (user.getUser_code().equals("") || user.getUser_password().equals("")) {
            //��2�����û���������Ϊ��
            addActionError("ȱ����Ҫ��Ϣ");
            return "addError";
        } else {
            //��3������Serviceִ�в����߼�
            flag = userService.saveUser(user);
        }

        // 2.��������ض�Ӧ������������Ϊ����ʵ������֮��Ӧ����error���ѡ���Ϊ����֮��Ӧ�ó��ִ���
        if (flag == true)
            return "login";//���ص���¼����
        else
            return ERROR;
    }

    //ɾ
    public String delete() {

        boolean flag = false;
        // 1.��ȡ����û�
        User user1 = userService.findByCode(user.getUser_code());
        // 2.����Serviceִ�в����߼�
        flag = userService.deleteUser(user1);
        // 3.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
        if (flag == true)
            return SUCCESS;
        else
            return ERROR;
    }

    //��
    public String update() {

        boolean flag = false;
        // 1.����Serviceִ�в����߼�
        flag = userService.updateUser(user);
        // 2.��������ض�Ӧ��������ʵ��ʵ������֮��Ӧ����error���ѡ��
        if (flag == true)
            return SUCCESS;
        else
            return ERROR;
    }

    //������
    public String list() {
        // 1.����Serviceִ�в����߼�
        List<User> list = userService.list();
        // 2.�����ص�list�������session��
        ActionContext.getContext().put("list", list);
        // 3.��ҳ����ת��list.jspҳ��
        return "list";
    }

    //ͨ���û�����
    public String findByCode() {
        // 1.����Serviceִ�в����߼�
        user = userService.findByCode(user.getUser_code());
        // 2.�����ص�list�������session��
        ActionContext.getContext().put("list", user);
        // 3.����ҳ����ת
        return "update";
    }

    //ͨ����������
    public String findByName() {
        // 1.����Serviceִ�в����߼�
        List<User> list = userService.findByName(user.getUser_name());
        // 2.�����ص�list�������session��
        ActionContext.getContext().put("list", list);
        // 3.����ҳ����ת
        return "list";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //ʹ��ģ��������ȡ����
    public User getModel() {
        return user;
    }


}
