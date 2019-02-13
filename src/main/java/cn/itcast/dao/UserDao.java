package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
	
	//�����û���¼���Ʋ�ѯuser����
	User getByUserCode(String usercode);
	//ע���û�
	void addUser(User u);
	//ɾ���û�
	void deleteUser(User user);
	//�޸��û���Ϣ
	void updateUser(User user);
	//��ʾ�����û�
	List<User> list();
	//�����û�ͨ���û���
	List<User> findByCode(String code);
	//�����û�ͨ������
	List<User> findByName(String name);

}
