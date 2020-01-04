<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: igorssnaidermans
  Date: 04/01/2020
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>

<html>
<%@include file="head.jsp" %>
<body>
<%--@elvariable id="users" type="java.util.List"--%>
<%--@elvariable id="user" type="lv.helloit.switter.user.User"--%>
<div class="container">
    <%@include file="navbar.jsp" %>
    <c:forEach items="${users}" var="user">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${user.email}</h5>
                <p class="card-text">${user.id}</p>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
