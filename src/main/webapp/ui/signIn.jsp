<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Вход в систему</title>
    <style>
        <%@include file='styles/signIn.css' %>
    </style>
</head>
<body>
    <div class="container">
        <h2>Войти</h2>
        <form id="signinForm" method="post" action="${pageContext.request.contextPath}/api/login">
            <label for="login">Логин:</label>
            <input type="text" id="login" name="login" required />

            <label for="password">Пароль:</label>
            <input type="password" id="password" name="password" required />

            <button type="submit">Войти</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <div class="error">${errorMessage}</div>
        </c:if>
    </div>
</body>
</html>