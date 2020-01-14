<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp" %>

<body>

<div class="container">
    <%@include file="navbar.jsp"%>
    <%--@elvariable id="switDTO" type="lv.helloit.switter.swit.SwitDTO"--%>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${switDTO.userEmail}</h5>
            <p class="card-text">${switDTO.content}</p>

            <p>Published: ${switDTO.publishDate}</p>
            <c:if test="${!switDTO.publishDate.equals(swit.lastUpdateDate)}">
                <p>Modified: ${switDTO.lastUpdateDate}</p>
            </c:if>
        </div>
    </div>
    <a href="/swit/${switDTO.id}/update" class="btn btn-primary">Update this swit</a>
    <a href="/" onclick="deleteSwitById(${switDTO.id})" class="btn btn-danger">Delete</a>

</div>
<%@include file="footer.jsp" %>
</body>
</html>
