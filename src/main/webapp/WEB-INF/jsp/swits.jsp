<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest swits</title>
    <link href="/styles.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="scripts.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<%--@elvariable id="swits" type="java.util.List"--%>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
<c:if test="${swits.isEmpty()}">
    Sorry, no swits for today!
</c:if>

<c:forEach items="${swits}" var="swit">
    <p class="author">Author: ${swit.author}</p>
    <a href="/swit/${swit.id}">
            ${swit.content}
    </a>
    <br />
</c:forEach>
<c:if test="${!swits.isEmpty()}">
<br/>
<button onclick="deleteAllSwits()">Delete all swits</button>
</c:if>
<br/>
<a href="/postSwit">Post new Swit</a>

</body>
</html>