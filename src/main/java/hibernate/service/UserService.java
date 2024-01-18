package hibernate.service;

import hibernate.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> allUsers();
    User update(User user);
    void delete(User user);
    User getById(Integer id);
}
