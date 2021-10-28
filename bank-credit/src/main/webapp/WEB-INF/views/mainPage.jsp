<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main Page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>

</head>
<body>
<p style="text-align:center; font-size:25px; color:blue">Main page!</p>
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
            <td class="pt-2 pb-2">
                <a class="btn btn-primary mb-2" data-toggle="collapse" href="#collapse-<c:out value="${row.id}"/>"
                   role="button" aria-expanded="false" aria-controls="collapseExample">
                    View tasks
                </a>
                <div class="collapse" id="collapse-<c:out value="${row.id}"/>">
                    <c:forEach var="rowTasks" items="${row.tasksList}">
                        <div>* <c:out value="${rowTasks.name}"/></div>
                    </c:forEach>
                </div>

            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
