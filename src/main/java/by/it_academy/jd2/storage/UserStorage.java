package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.service.api.EFeature;
import by.it_academy.jd2.storage.api.EVoteStorageType;
import by.it_academy.jd2.storage.api.IStorageSwitcher;
import by.it_academy.jd2.storage.api.IUserStorage;

import java.util.List;
import java.util.Map;

public class UserStorage implements IUserStorage, IStorageSwitcher {
    private final Map<EVoteStorageType, IUserStorage> storage;
    private static EVoteStorageType currentType;

    public UserStorage(Map<EVoteStorageType, IUserStorage> storage,
                       EFeature defaultFeature) {
        this.storage = storage;

        toggle(defaultFeature.getDefault());
    }

    @Override
    public void add(User user) {
        this.getStorage().add(user);
    }

    @Override
    public List<User> getAll() {
        return getStorage().getAll();
    }

    @Override
    public int countUsers() {
        return getStorage().countUsers();
    }

    @Override
    public void toggle(String value) {
        currentType = EVoteStorageType.valueOf(value);
    }

    private IUserStorage getStorage(){
        return this.storage.get(currentType);
    }
}
