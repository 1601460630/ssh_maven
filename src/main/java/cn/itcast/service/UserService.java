package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
	//登录方法
	//User getUserByCodePassword(User u);
	//注册用户
	boolean saveUser(User u);
	//删除用户
	boolean deleteUser(User u);
	//修改用户
	boolean updateUser(User u);
	//显示所有用户
	List<User> list();
	//通过用户名查找用户
	User findByCode(String code);
	//通过姓名查找用户
	List<User> findByName(String name);
}
