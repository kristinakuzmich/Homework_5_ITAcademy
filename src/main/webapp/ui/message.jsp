<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8" />
    <title>Сообщения</title>
    <style>
        <%@include file='styles/message.css' %>
    </style>
</head>
<body>
    <h2>Отправить сообщение</h2>
    <form action="${pageContext.request.contextPath}/api/message" method="post">
        <label for="to">Кому:</label>
        <input type="text" id="to" name="to" required /><br/><br/>

        <label for="text">Текст:</label><br/>
        <textarea id="text" name="text" rows="4" cols="50" required></textarea><br/><br/>

        <button type="submit">Отправить</button>
    </form>
</body>
</html>