<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <title>Выход из системы</title>
    <meta http-equiv="refresh" content="3; URL=${pageContext.request.contextPath}/api/logout" />
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 50px;
        }
    </style>
</head>
<body>
    <h2>Вы успешно вышли из системы</h2>
    <p>Перенаправление на главную страницу через 3 секунды...</p>
</body>
</html>