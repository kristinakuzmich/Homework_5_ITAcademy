package by.it_academy.jd2.service;

import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.StorageFactory;


public class ServiceFactory {

    private final static IUserService userService = new UserService(
            StorageFactory.getUserStorage()
    );

    private final static IMessageService messageService = new MessageService(
            StorageFactory.getMessageStorage()
    );

    public static IMessageService getMessageService() {
        return messageService;
    }

    public static IUserService getUserService() {
        return userService;
    }
}