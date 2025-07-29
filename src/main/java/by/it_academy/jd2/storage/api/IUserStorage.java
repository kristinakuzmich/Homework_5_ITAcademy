package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.storage.api.exceptions.StorageException;

import java.util.List;

public interface IUserStorage {

    /**
     * Сохранение данных
     * @param user пользователь
     * @throws StorageException - ошибка работы с хранилищем
     */
    void add(User user);
    List<User> getAll();
    int countUsers();
}
