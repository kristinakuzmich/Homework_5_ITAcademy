package by.it_academy.jd2.service;

import by.it_academy.jd2.dto.Message;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.storage.MessageStorageSQL;

import java.util.List;
import java.util.stream.Collectors;

public class MessageService implements IMessageService {
    private MessageStorageSQL storage;

    public MessageService(MessageStorageSQL storage) {
        this.storage = storage;
    }

    @Override
    public List<Message> getMessagesForUser(String login) {
        return storage.getAll().stream()
                .filter(m -> m.getToUser().equals(login) || m.getFromUser().equals(login))
                .collect(Collectors.toList());
    }

    @Override
    public void saveMessage(Message message) {
        storage.add(message);
    }

    public int countMessages(){
        return storage.countMessages();
    }
}