package web.service;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();
    User getUser(Long id);
    void addUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
}
