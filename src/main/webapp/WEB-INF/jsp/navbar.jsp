<%String currentPage = request.getParameter("currentPage");%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Switter</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/postSwit"><fmt:message key="post"/> </a>
            </li>
            <li>
                <a class="nav-link" href="/" onclick="deleteAllSwits()"><fmt:message key="delete.all.swits"/></a>
            </li>
            <li>
                <a class="nav-link" href="/userlist"><fmt:message key="users"/></a>
            </li>
        </ul>
        <a class="nav-link" href="/signup"><fmt:message key="sign.up"/></a>
        <a class="nav-link" href="/logout">Logout</a>
        <a class="nav-link" href="?sessionLocale=lv">LV</a>
        <a href="?sessionLocale=en">EN</a>
    </div>
</nav>

</body>
</html>
