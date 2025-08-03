package by.it_academy.jd2.service;

import by.it_academy.jd2.controller.listeners.UserSessionListener;
import by.it_academy.jd2.service.api.IMessageService;
import by.it_academy.jd2.service.api.IStatService;
import by.it_academy.jd2.service.api.IUserService;

public class StatisticsService implements IStatService {

    private final IUserService userService;
    private final IMessageService messageService;

    public StatisticsService(IUserService userService, IMessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @Override
    public int getActiveUsers() {
        return UserSessionListener.getActiveUserCount();
    }

    public int getTotalUsers() {
        return userService.countUsers();
    }

    public int getTotalMessages() {
        return messageService.countMessages();
    }
}
