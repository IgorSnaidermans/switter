<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp" %>

<body>

<div class="container">
    <%@include file="navbar.jsp"%>
    <%--@elvariable id="swit" type="lv.helloit.switter.swit.Swit"--%>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${swit.author}</h5>
            <p class="card-text">${swit.content}</p>

            <p>Published: ${swit.publishDate}</p>
            <c:if test="${!swit.publishDate.equals(swit.lastUpdateDate)}">
                <p>Modified: ${swit.lastUpdateDate}</p>
            </c:if>
        </div>
    </div>
    <a href="/swit/${swit.id}/update" class="btn btn-primary">Update this swit</a>
    <a href="/" onclick="deleteSwitById(${swit.id})" class="btn btn-danger">Delete swit</a>

</div>
</body>
</html>
