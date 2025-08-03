package by.it_academy.jd2.storage;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.storage.api.IUserStorage;

import java.util.ArrayList;
import java.util.List;

public class UserStorageRam implements IUserStorage {
    private final List<User> votes = new ArrayList<>();

    @Override
    public void add(User vote) {
        this.votes.add(vote);
    }

    @Override
    public List<User> getAll() {
        return this.votes;
    }

    @Override
    public int countUsers() {
        return this.votes.size();
    }
}
