<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>一覧</title>
    </head>
    <body>
        <h1>コンテンツ一覧</h1>
        <table border="1">
            <tr><th>ID</th><th>タイトル</th><th></th></tr>
            <c:forEach var="item" items="${contentList}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.title}</td>
                    <td>
                        <a href="detail.jsp?id=${item.id}">詳細</a>
                    </td>
                    </td>
            </c:forEach>
            </table>
    </body>
</html>