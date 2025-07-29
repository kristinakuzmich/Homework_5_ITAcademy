<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8" />
<title>Регистрация пользователя</title>
<style>
    <%@include file='styles/signUp.css' %>
</style>
</head>
<body>
<div class="container">
    <h2>Регистрация нового пользователя</h2>
    <form action="${pageContext.request.contextPath}/api/user" method="post">
        <label for="login">Логин:</label>
        <input type="text" id="login" name="login" required />

        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" required />

        <label for="fullName">ФИО:</label>
        <input type="text" id="fullName" name="fullName" required />

        <label for="birthDate">Дата рождения:</label>
        <input type="date" id="birthDate" name="birthDate" required />

        <button type="submit">Зарегистрироваться</button>
    </form>
</div>
</body>
</html>