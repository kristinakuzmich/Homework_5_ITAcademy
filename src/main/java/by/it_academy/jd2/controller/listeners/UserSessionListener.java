package by.it_academy.jd2.controller.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class UserSessionListener implements HttpSessionListener {

    private static final AtomicInteger activeUserSessions = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Object user = se.getSession().getAttribute("user");
        if (user != null) {
            activeUserSessions.incrementAndGet();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Object user = se.getSession().getAttribute("user");
        if (user != null) {
            activeUserSessions.decrementAndGet();
        }
    }

    public static int getActiveUserCount() {
        return activeUserSessions.get();
    }
}
