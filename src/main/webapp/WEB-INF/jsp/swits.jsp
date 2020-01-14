<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>


<%@include file="head.jsp" %>

<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" />

<body>

<div class="container">
    <%@include file="navbar.jsp" %>
    <%--@elvariable id="swits" type="java.util.List"--%>
    <%--@elvariable id="switDTO" type="lv.helloit.switter.swit.SwitDTO"--%>
    <c:if test="${swits.isEmpty()}">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title"><fmt:message key="no.swits" /></h5>
                <a href="/postSwit" class="btn btn-primary"><fmt:message key="post"/></a>
            </div>
        </div>
    </c:if>

    <c:forEach items="${swits}" var="switDTO">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${switDTO.userEmail}</h5>
                <p class="card-text">${switDTO.content}</p>
                <p class="card-text">${switDTO.publishDate}</p>
                <a href="/swit/${switDTO.id}" class="btn btn-primary"><fmt:message key="edit" /></a>
                <a href="/" onclick="deleteSwitById(${switDTO.id})" class="btn btn-danger"><fmt:message key="delete" /></a>
            </div>
        </div>
    </c:forEach>
    <br/>


</div>

<%@include file="footer.jsp" %>
</body>
</html>