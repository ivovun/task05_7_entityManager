package net.jm.springmvc.dao;

import net.jm.springmvc.entity.User;

import java.util.List;
import java.util.Set;

public interface UserDAO {
    List<User> findAll();

    User findOne(long id);

    void create(User entity);

    User update(User entity);

    void delete(User entity);

    void deleteById(long entityId);
}
