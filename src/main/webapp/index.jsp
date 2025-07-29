<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Главная страница</title>
    <style>
        <%@include file='ui/styles/index.css' %>
    </style>
</head>
<body>
    <h1>Добро пожаловать в систему сообщений</h1>

    <c:if test="${not empty sessionScope.user}">
        <h2>Добро пожаловать, ${sessionScope.user}!</h2>
        <p>Вы успешно вошли в систему.</p>
    </c:if>

    <c:if test="${not empty sessionScope.error}">
        <div style="color: red; font-weight: bold;">
            Пользователь ${sessionScope.error} не найден!
        </div>
    </c:if>

    <c:if test="${not empty sessionScope.register}">
        <h2>Пользователь ${sessionScope.register} успешно зарегистрирован!</h2>
    </c:if>

    <c:if test="${not empty sessionScope.to}">
        <h2>Ваше сообщение для ${sessionScope.to} успешно отправлено!</h2>
    </c:if>

    <div class="nav">
        <a href="${pageContext.request.contextPath}/ui/signIn.jsp">Вход</a>
        <a href="${pageContext.request.contextPath}/ui/signUp.jsp">Регистрация</a>
        <a href="${pageContext.request.contextPath}/ui/message.jsp">Отправить сообщение</a>
        <a href="${pageContext.request.contextPath}/api/message">Мои сообщения</a>
        <a href="${pageContext.request.contextPath}/api/admin/statistics">Статистика</a>
        <a href="${pageContext.request.contextPath}/ui/logout.jsp">Выход</a>
    </div>
</body>
</html>