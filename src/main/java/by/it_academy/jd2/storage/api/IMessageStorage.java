package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.dto.Message;
import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.storage.api.exceptions.StorageException;

import java.util.List;

public interface IMessageStorage {
    /**
     * Сохранение данных
     * @param msg сообщение
     * @throws StorageException - ошибка работы с хранилищем
     */
    void add(Message msg);
    List<Message> getAll();
    int countMessages();
}
