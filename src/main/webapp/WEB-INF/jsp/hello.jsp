<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}!</title>
</head>
<body>
<h2 class="hello-title">Hello ${visitorName}!</h2>
<ol>
    <jstl:forEach items="${numbers}" var="i">
        <li>${i}</li>
    </jstl:forEach>
</ol>
</body>
</html>
