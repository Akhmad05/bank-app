<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main Page</title>

    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>

    <script type="text/javascript">
        function doAjaxPost(id) {
            $.ajax({
                type: "GET",
                url: "/epz/test/gettasksperson",
                data: "id=" + id,
                success: function (response) {
                    var person = JSON.parse(response);
                    $(person.idElement).html(person.text);
                },
                error: function (e) {
                    alert('Error: ' + e);
                }
            });
        }
    </script>
</head>
<body>
<p style="text-align:center; font-size:25px;">Main page!</p>
<table border="1" width="100%" style="text-align: center">
    <tr>
        <th width="10%">ID USER</th>
        <th width="30%">USER NAME</th>
        <th width="60%">TASKS</th>
    </tr>
    <c:forEach var="row" items="${results}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.firstname}"/></td>
            <td>
                <button onclick="doAjaxPost(<c:out value="${row.id}"/>)">Показать задачи</button>
                <div id="tasks<c:out value="${row.id}"/>"></div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
