package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.service.ServiceFactory;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.api.exceptions.StorageException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {

    private final IUserService service = ServiceFactory.getUserService();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || login.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\":\"Заполните логин и пароль\"}");
            return;
        }

        try {
            User authUser = service.login(login, password);
            if (authUser != null) {
                session.setAttribute("user", login);
                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect(request.getContextPath() + "/index");
            }
            else {
                session.setAttribute("error", login);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.sendRedirect(request.getContextPath() + "/index");
            }
        } catch (StorageException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Ошибка сервера" + e.getMessage());
        }
    }
}