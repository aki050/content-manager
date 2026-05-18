<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>詳細</title>
    </head>
    <body>
        <h1>${content.title}</h1>

    <c:coose>
        <c:when test=""${not contnt.adminOnly or pageContext.request.isUserInRole('ADMIN')}">
            <p>${content.description}</p>
        </c:when>
        <c:otherwise>
            <p>閲覧権限がありません。</p>
        </c:otherwise>
    </c:coose>
    <c:if test="${not empty content.filePath}">
        <a href=""../user/download?file=${content.filePath}">
            ダウンロード
        </a>
    </c:if>

    <br><a href="list.jsp">
        戻る
    </a>
    </body>
</html>