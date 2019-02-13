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

    //�߼��ع���ת����Action��
    //��ʵ����������׳�����ʾӦ�ö���  �û������������
    //���Ը���������Ƕ�ע�ͣ�������������һ��������Ч
    /*@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByCodePassword(User u) {
        //1.���ݵ�¼���Ʋ�ѯ��¼�û�
        User existU = ud.getByUserCode(u.getUser_code());
        //2.�жϵ�¼�û��Ƿ����,������=>�׳��쳣,��ʾ�û���������
        if (existU == null) {
            throw new RuntimeException("�û��������ڣ�");
        }
        //3.�ж��û��������Ƿ���ȷ,����ȷ=>�׳��쳣,��ʾ�������
        if (!existU.getUser_password().equals(u.getUser_password())) {
            throw new RuntimeException("�������");
        }
        //4.���ز�ѯ�����û�����

        return existU;
    }*/

    public boolean saveUser(User u) {
        // ���ó�ʼֵΪfalse
        boolean flag = false;

        try {
            // ����DAO����ķ���,ִ�����ݿ����
            ud.addUser(u);
            // �ɹ��򷵻�true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ������ȷ�����
        return flag;
    }

    public boolean deleteUser(User u) {
        // ���ó�ʼֵΪfalse
        boolean flag = false;
        try {
            // ����DAO����ķ���,ִ�����ݿ����
            ud.deleteUser(u);
            // �ɹ��򷵻�true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ������ȷ�����
        return flag;
    }

    public boolean updateUser(User u) {
        // ���ó�ʼֵΪfalse
        boolean flag = false;

        try {
            // ����DAO����ķ���,ִ�����ݿ����
            ud.updateUser(u);
            // �ɹ��򷵻�true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ������ȷ�����
        return flag;
    }


    //������
    public List<User> list() {

        return ud.list();
    }

    //ͨ���û��������û�
    public User findByCode(String code) {
        //����listΪ��ʱ��list.get(0)�ᱨ�������������´�����ô����ǰ����Ĭ�����ݿ��в������ظ����û���
        if (ud.findByCode(code).size() == 1)
            return ud.findByCode(code).get(0);
        else
            return null;
    }

    //ͨ�����������û�
    public List<User> findByName(String name) {

        return ud.findByName(name);
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }


}
