<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<p style="text-align:center; font-size:25px; color:blue">Main page!</p>
<table border="1" width="100%">
    <tr>
        <th>ID USER</th>
        <th>USER NAME</th>
        <th>AMOUNT TASKS</th>

    </tr>
    <c:forEach var="row" items="${results}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.firstname}"/></td>
            <td><c:out value="${row.tasksList.size()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
