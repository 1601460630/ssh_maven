package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.domain.User;
import cn.itcast.dao.*;

//这里的代码是我在暑假里写的，不要问我写的是什么东西，现在我自己也分不清
//HibernateDaoSupport为dao注入sessionFactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    //根据用户登录名称查询user对象
    //这个方法不能像增删查改一样，就简简单单一句话，是要判断的，要是没查到，是应该在页面上显示相关的报错的
    public User getByUserCode(String usercode) {
        //HQL
		/*return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				
				String hql="form User where user_code = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				User user = (User) query.uniqueResult();
				return user;
			}
		});*/

        //Criteria，hibernate有三种查询语言，hql，sql，以及这个Criteria，我忘光了,不要问为什么，问就是 不知道
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);

        dc.add(Restrictions.eq("user_code", usercode));

        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);

        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //注册用户
    public void addUser(User u) {

        this.getHibernateTemplate().save(u);
    }

    //删除用户
    public void deleteUser(User user) {

        this.getHibernateTemplate().delete(user);
    }

    //修改用户
    public void updateUser(User user) {

        this.getHibernateTemplate().update(user);
    }
    //显示所有用户
    public List<User> list() {

        List<User> list = (List<User>) this.getHibernateTemplate().find(" from User");
        return list;
    }
    //通过用户名查找用户
    public List<User> findByCode(String code) {

        return (List<User>) this.getHibernateTemplate().find(" from User where user_code = ? ", code);
    }
    //通过姓名查找用户
    public List<User> findByName(String name) {

        return (List<User>) this.getHibernateTemplate().find(" from User where user_name = ? ", name);
    }

}
