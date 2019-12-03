package net.jm.springmvc.service;

import net.jm.springmvc.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> findAll();

    void update(User user);

    void create(User user);

    User findOne(long userId);

    void deleteById(long userId);

}
