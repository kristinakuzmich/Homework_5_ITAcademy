package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.User;

public interface IUserService {
    void registerUser(User user);
    User login(String login, String password);
    int countUsers();
}