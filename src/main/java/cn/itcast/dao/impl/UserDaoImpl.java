package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.domain.User;
import cn.itcast.dao.*;

//����Ĵ��������������д�ģ���Ҫ����д����ʲô�������������Լ�Ҳ�ֲ���
//HibernateDaoSupportΪdaoע��sessionFactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    //�����û���¼���Ʋ�ѯuser����
    //���������������ɾ���һ�����ͼ�򵥵�һ�仰����Ҫ�жϵģ�Ҫ��û�鵽����Ӧ����ҳ������ʾ��صı����
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

        //Criteria��hibernate�����ֲ�ѯ���ԣ�hql��sql���Լ����Criteria����������,��Ҫ��Ϊʲô���ʾ��� ��֪��
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);

        dc.add(Restrictions.eq("user_code", usercode));

        List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);

        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    //ע���û�
    public void addUser(User u) {

        this.getHibernateTemplate().save(u);
    }

    //ɾ���û�
    public void deleteUser(User user) {

        this.getHibernateTemplate().delete(user);
    }

    //�޸��û�
    public void updateUser(User user) {

        this.getHibernateTemplate().update(user);
    }
    //��ʾ�����û�
    public List<User> list() {

        List<User> list = (List<User>) this.getHibernateTemplate().find(" from User");
        return list;
    }
    //ͨ���û��������û�
    public List<User> findByCode(String code) {

        return (List<User>) this.getHibernateTemplate().find(" from User where user_code = ? ", code);
    }
    //ͨ�����������û�
    public List<User> findByName(String name) {

        return (List<User>) this.getHibernateTemplate().find(" from User where user_name = ? ", name);
    }

}
