package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
	
	//根据用户登录名称查询user对象
	User getByUserCode(String usercode);
	//注册用户
	void addUser(User u);
	//删除用户
	void deleteUser(User user);
	//修改用户信息
	void updateUser(User user);
	//显示所有用户
	List<User> list();
	//查找用户通过用户名
	List<User> findByCode(String code);
	//查找用户通过姓名
	List<User> findByName(String name);

}
