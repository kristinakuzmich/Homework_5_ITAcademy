package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.Message;
import by.it_academy.jd2.service.api.EFeature;
import by.it_academy.jd2.storage.api.EVoteStorageType;
import by.it_academy.jd2.storage.api.IStorageSwitcher;
import by.it_academy.jd2.storage.api.IMessageStorage;

import java.util.List;
import java.util.Map;

public class MessageStorage implements IMessageStorage, IStorageSwitcher {
    private final Map<EVoteStorageType, IMessageStorage> storage;
    private static EVoteStorageType currentType;

    public MessageStorage(Map<EVoteStorageType, IMessageStorage> storage,
                          EFeature defaultFeature) {
        this.storage = storage;

        toggle(defaultFeature.getDefault());
    }

    @Override
    public void add(Message vote) {
        this.getStorage().add(vote);
    }

    @Override
    public List<Message> getAll() {
        return getStorage().getAll();
    }

    @Override
    public int countMessages() {
        return getStorage().countMessages();
    }

    @Override
    public void toggle(String value) {
        currentType = EVoteStorageType.valueOf(value);
    }

    private IMessageStorage getStorage(){
        return this.storage.get(currentType);
    }
}
