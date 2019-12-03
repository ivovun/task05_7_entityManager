package net.jm.springmvc.dao;

import net.jm.springmvc.entity.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {

    List<User> getUsers();

    void saveUser(User user);

    User getUser(long userId);

    void deleteUser(long userId);

}
