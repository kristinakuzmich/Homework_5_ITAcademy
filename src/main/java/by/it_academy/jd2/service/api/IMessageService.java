package by.it_academy.jd2.service.api;

import by.it_academy.jd2.dto.Message;
import by.it_academy.jd2.dto.User;

import java.util.List;

public interface IMessageService {
    List<Message> getMessagesForUser(String login);
    void saveMessage(Message message);
}