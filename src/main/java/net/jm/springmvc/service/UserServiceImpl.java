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
//	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
//	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}

	@Override
//	@Transactional
	public User getUser(long userId) {
		return userDAO.getUser(userId);
	}

	@Override
//	@Transactional
	public void deleteUser(long userId) {
		userDAO.deleteUser(userId);
	}
}





