<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>

    <script type="text/javascript">
        function doAjaxPostNewTask(id) {
            $.ajax({
                type: "POST",
                url: "/epz/test/task",
                data: "name=" + $("#nameTask").val() + "&id=" + id,
                success: function (response) {
                    // var person = JSON.parse(response);
                    // $(person.idElement).html(person.text);
                    alert("Задача добавлена");
                },
                error: function (e) {
                    alert('Error: ' + e);
                }
            });
        }
    </script>

</head>
<body>
<span>Добавление новой задачи</span>
<form id="formTask" method="post">
    <table style="border-spacing: 7px 15px;">
        <tr>
            <td><label>Описание: </label></td>
            <td><input id="nameTask" type="text" name="taskname" id="taskName">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button onclick="doAjaxPostNewTask(<c:out value="${person.id}"/>); return false;">Добавить</button>
            </td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/main">Перейти на главную страницу</a>
<%--<button onclick="doAjaxPostUpdateTask(<c:out value="${task.id}"/>)">Обновить</button>--%>
</body>
</html>
