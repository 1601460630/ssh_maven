package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
	//��¼����
	//User getUserByCodePassword(User u);
	//ע���û�
	boolean saveUser(User u);
	//ɾ���û�
	boolean deleteUser(User u);
	//�޸��û�
	boolean updateUser(User u);
	//��ʾ�����û�
	List<User> list();
	//ͨ���û��������û�
	User findByCode(String code);
	//ͨ�����������û�
	List<User> findByName(String name);
}
