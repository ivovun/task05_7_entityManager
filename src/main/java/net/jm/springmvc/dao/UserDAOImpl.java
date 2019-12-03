package net.jm.springmvc.dao;

import net.jm.springmvc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

//	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	}

	@Override
	public void deleteUser(long userId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.byId(User.class).load(userId));
	}

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public User getUser(long userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}
}
