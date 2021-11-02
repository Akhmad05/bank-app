<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="<c:url value="/resources/js/jquery-3.6.0.min.js" />"></script>

    <script type="text/javascript">
        function doAjaxPostUpdateTask(id) {
            $.ajax({
                type: "PATCH",
                url: "/epz/test/task/" + id,
                data: "name=" + $("#nameTask").val(),
                success: function (response) {
                    // var person = JSON.parse(response);
                    // $(person.idElement).html(person.text);
                    alert("Задача обновлена");
                },
                error: function (e) {
                    alert('Error: ' + e);
                }
            });
        }
    </script>

</head>
<body>
<span>Редактирование задачи</span>
<form id="formTask" method="post">
    <table style="border-spacing: 7px 15px;">
        <tr>
            <td><label>Описание: </label></td>
            <td><input id="nameTask" type="text" name="firstname" value="<c:out value="${task.name}"/>" id="firstName">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button onclick="doAjaxPostUpdateTask(<c:out value="${task.id}"/>); return false;">Обновить</button>
            </td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/main">Перейти на главную страницу</a>
<%--<button onclick="doAjaxPostUpdateTask(<c:out value="${task.id}"/>)">Обновить</button>--%>
</body>
</html>
