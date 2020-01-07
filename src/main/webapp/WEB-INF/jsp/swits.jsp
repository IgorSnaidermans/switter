<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp" %>

<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <%--@elvariable id="swits" type="java.util.List"--%>
    <%--@elvariable id="swit" type="lv.helloit.switter.swit.Swit"--%>
    <c:if test="${swits.isEmpty()}">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">No swits, be the first one!</h5>
                <a href="/postSwit" class="btn btn-primary">Post new Swit</a>
            </div>
        </div>
    </c:if>

    <c:forEach items="${swits}" var="swit">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${swit.userId}</h5>
                <p class="card-text">${swit.content}</p>
                <a href="/swit/${swit.id}" class="btn btn-primary">More information</a>
                <a href="/" onclick="deleteSwitById(${swit.id})" class="btn btn-danger">Delete swit</a>
            </div>
        </div>
    </c:forEach>
    <br/>


</div>
</body>
</html>