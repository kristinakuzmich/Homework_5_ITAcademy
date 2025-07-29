package by.it_academy.jd2.controller;

import by.it_academy.jd2.dto.User;
import by.it_academy.jd2.dto.UserRole;
import by.it_academy.jd2.service.ServiceFactory;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.StorageFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@WebServlet(urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    private final IUserService service = ServiceFactory.getUserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String birthDateStr = request.getParameter("birthDate");


        Optional<User> existing = StorageFactory.getUserStorage().getAll().stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
        if (existing.isPresent()) {
            response.getWriter().write("Такой пользователь уже существует");
            return;
        }

        if (login.trim().isEmpty() || password.trim().isEmpty() || fullName.trim().isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Заполните все поля");
            return;
        }

        Date birthDate;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            sdf.setLenient(false);
            birthDate = sdf.parse(birthDateStr.toString());
        } catch (ParseException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Некорректный формат даты. Используйте формат дд.мм.гггг");
            return;
        }

        service.registerUser(User.builder()
                .login(login)
                .password(password)
                .fullName(fullName)
                .birthDate(birthDate)
                .registrationDate(now())
                .role(UserRole.USER.toString())
                .build());

        session.setAttribute("register", login);
        response.sendRedirect(request.getContextPath() + "/index");
    }
}
