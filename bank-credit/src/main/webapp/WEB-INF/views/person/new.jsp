<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span>Добавление пользователя</span>
<form action="/epz/test/main/<c:out value="${person.id}"/>" method="post">
    <table style="border-spacing: 7px 15px;">
        <tr>
            <td><label>Имя: </label></td>
            <td><input type="text" name="firstname" id="firstName"></td>
        </tr>
        <tr>
            <td><label>Фамилия: </label></td>
            <td><input type="text" name="lastname" id="lastName"></td>
        </tr>
        <input type="hidden" name="_method" value="post"/>
        <tr>
            <td colspan="2"><input type="submit" value="Добавить"></td>
        </tr>
    </table>
</form>

</body>
</html>
