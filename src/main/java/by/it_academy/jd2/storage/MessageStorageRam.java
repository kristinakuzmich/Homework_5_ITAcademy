package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.Message;
import by.it_academy.jd2.storage.api.IMessageStorage;

import java.util.ArrayList;
import java.util.List;

public class MessageStorageRam implements IMessageStorage {
    private final List<Message> messages = new ArrayList<>();

    @Override
    public void add(Message vote) {
        this.messages.add(vote);
    }

    @Override
    public List<Message> getAll() {
        return this.messages;
    }

    @Override
    public int countMessages() {
        return this.messages.size();
    }
}
