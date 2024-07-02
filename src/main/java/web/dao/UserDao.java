package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();
    User getUser(Long id);
    void addUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
