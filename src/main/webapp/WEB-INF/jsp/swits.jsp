<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest swits</title>
</head>
<body>
<%--@elvariable id="swits" type="java.util.List"--%>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
<c:if test="${swits.isEmpty()}">
    Sorry, no swits for you!
</c:if>

<c:forEach items="${swits}" var="swit">
    <p style="font-weight: bold;">${swit.author}: </p>
    <a href="/swit/${swit.id}">
            ${swit.content}
    </a>
    <br />
</c:forEach>
</body>
</html>
