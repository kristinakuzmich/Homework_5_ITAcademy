package by.it_academy.jd2.controller;

import by.it_academy.jd2.core.ContextFactory;
import by.it_academy.jd2.service.api.IStatService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private static final IStatService statService = ContextFactory.getBean(IStatService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Map<String, Object> stats = new HashMap<>();
        stats.put("activeUsers", statService.getActiveUsers());
        stats.put("totalRegisteredUsers", statService.getTotalUsers());
        stats.put("totalSentMessages", statService.getTotalMessages());

        resp.setStatus(HttpServletResponse.SC_OK);
        req.setAttribute("stats", stats);
        req.getRequestDispatcher("/ui/statistics.jsp").forward(req, resp);
    }
}