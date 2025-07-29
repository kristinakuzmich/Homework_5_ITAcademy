<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="by.it_academy.jd2.dto.Message" %>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8" />
<title>Ваши сообщения</title>
<style>
    <%@include file='styles/chats.css' %>
</style>
</head>
<body>

<h2>Сообщения, отправленные вам</h2>

<table>
    <thead>
        <tr>
            <th>Дата и время</th>
            <th>От кого</th>
            <th>Текст сообщения</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Message> messages = (List<Message>) request.getAttribute("messages");
            if (messages != null) {
                for (Message msg : messages) {
        %>
        <tr>
            <td><%= msg.getSendTime() %></td>
            <td><%= msg.getFromUser() %></td>
            <td><%= msg.getText() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3" style="text-align:center;">Нет сообщений</td>
        </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>