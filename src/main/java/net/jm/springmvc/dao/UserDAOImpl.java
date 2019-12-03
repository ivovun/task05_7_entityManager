package net.jm.springmvc.dao;

import net.jm.springmvc.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends AbstractJpaDAO<User> implements UserDAO {
	public UserDAOImpl() {
		super();
		setClazz(User.class);
	}
}
