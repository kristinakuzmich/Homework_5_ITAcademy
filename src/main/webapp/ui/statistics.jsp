<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8" />
<title>Статистика приложения</title>
<style>
    <%@include file='styles/statistics.css' %>
</style>
</head>
<body>

<h2>Статистика приложения</h2>

<div class="stats">
    <%
        Map<String, Object> stats = (Map<String, Object>) request.getAttribute("stats");
        if (stats != null) {
            Object activeUsers = stats.get("activeUsers");
            Object totalUsers = stats.get("totalRegisteredUsers");
            Object totalMessages = stats.get("totalSentMessages");
    %>
    <div class="stat-item">Активные пользователи: <strong><%= activeUsers != null ? activeUsers : "0" %></strong></div>
    <div class="stat-item">Всего зарегистрированных пользователей: <strong><%= totalUsers != null ? totalUsers : "0" %></strong></div>
    <div class="stat-item">Всего отправленных сообщений: <strong><%= totalMessages != null ? totalMessages : "0" %></strong></div>
    <% } else { %>
    <div style="text-align:center;">Нет данных о статистике.</div>
    <% } %>
</div>

</body>
</html>