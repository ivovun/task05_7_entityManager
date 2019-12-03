package net.jm.springmvc.service;

import net.jm.springmvc.dao.UserDAO;
import net.jm.springmvc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
//	убрал тут @Autowired
	private UserDAO userDAO;

//	тут не нужно @Autowired так как единственный конструтор
	public UserServiceImpl(UserDAO userDAO){
		this.userDAO = userDAO;
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public void create(User user) {
		userDAO.create(user);
	}

	@Override
	public User findOne(long userId) {
		return userDAO.findOne(userId);
	}

	@Override
	public void deleteById(long userId) {
		userDAO.deleteById(userId);
	}
}





