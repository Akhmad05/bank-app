<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main Page</title>
    <meta charset="UTF-8">
    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>

    <script type="text/javascript">
        let isRun = [];

        function doAjaxPost(id) {
            if (isRun.includes(id) == false) {
                $.ajax({
                    type: "GET",
                    url: "/epz/test/main/gettasksperson",
                    data: "id=" + id,
                    success: function (response) {
                        var person = JSON.parse(response);
                        $(person.idElement).html(person.text);
                        isRun.push(id);
                    },
                    error: function (e) {
                        alert('Error: ' + e);
                    }
                });
            }
        }
    </script>
</head>
<body>
<p style="text-align:center; font-size:25px;">Main page!</p>
<p><a href="./main/new">Добавить пользователя</a></p>
<table border="1" width="100%" style="text-align: center">
    <tr>
        <th width="10%">Идентификатор</th>
        <th width="30%">Имя</th>
        <th width="40%">Задачи</th>
        <th width="20%">Действие</th>
    </tr>
    <c:forEach var="row" items="${results}">
        <tr>
            <td><span><c:out value="${row.id}"/></span></td>
            <td>
                <span><c:out value="${row.firstname}"/></span>
            </td>
            <td style="vertical-align: initial; padding-top: 10px;">
                <button onclick="doAjaxPost(<c:out value="${row.id}"/>)">Показать задачи</button>
                <div id="tasks<c:out value="${row.id}"/>"></div>
            </td>
            <td>
                <div><a href="./main/<c:out value="${row.id}"/>/edit">изменить</a></div>
                <div style="margin-top: 5px">
                    <form action="./main/<c:out value="${row.id}"/>" method="post">
                        <input type="hidden" name="_method" value="delete"/>
                        <input type="submit" value="удалить">
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
