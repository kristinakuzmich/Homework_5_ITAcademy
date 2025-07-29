package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.*;
import by.it_academy.jd2.service.ServiceFactory;
import by.it_academy.jd2.service.api.IMessageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static java.time.LocalDateTime.now;

@WebServlet("/api/message")
public class MessageServlet extends HttpServlet {

    private final IMessageService messageService = ServiceFactory.getMessageService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Вы не авторизованы\"}");
            return;
        }
        try {
            List<Message> messages = messageService.getMessagesForUser(user.toString());
            response.setStatus(HttpServletResponse.SC_OK);
            request.setAttribute("messages", messages);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Ошибка сервера\"}");
        }
        request.getRequestDispatcher("/ui/chats.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("application/json;charset=UTF-8");
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"error\":\"Вы не авторизованы\"}");
            return;
        }
        String login = user.toString();

        String to = request.getParameter("to");
        String text = request.getParameter("text");

        if (to == null || to.trim().isEmpty() || text == null || text.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\":\"Заполните получателя и текст\"}");
            return;
        }

        try {
            Message message = Message.builder()
                    .from(login)
                    .to(to)
                    .text(text)
                    .sendTime(now())
                    .build();

            messageService.saveMessage(message);
            response.setStatus(HttpServletResponse.SC_OK);
            session.setAttribute("to", to);
            response.sendRedirect(request.getContextPath() + "/index");

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Ошибка сервера\"}");
        }
    }
}