package by.it_academy.jd2.service.api;

import by.it_academy.jd2.storage.StorageFactory;

public class Statistics {

    public static int getTotalUsers() {
        return StorageFactory.getUserStorage().countUsers();
    }

    public static int getTotalMessages() {
        return StorageFactory.getMessageStorage().countMessages();
    }
} 