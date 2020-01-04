<%
    String currentPage = request.getParameter("currentPage");
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a class="nav-link" href="/postSwit">Post Swit</a>
            </li>
            <li>
                <a class="nav-link" href="/" onclick="deleteAllSwits()">Delete all swits</a>
            </li>
            <li>
                <a class="nav-link" href="/userlist">Users</a>
            </li>
        </ul>
        <a class="nav-link" href="/signup">Sign Up</a>
    </div>
</nav>

</body>
</html>
