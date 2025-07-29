package by.it_academy.jd2.service;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.api.IUserStorage;

public class UserService implements IUserService {

    private final IUserStorage storage;

    public UserService(IUserStorage storage) {
        this.storage = storage;
    }

    @Override
    public void registerUser(User user) {
        storage.add(user);
    }

    @Override
    public User login(String login, String password) {
        return storage.getAll().stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst().orElse(null);
    }
}