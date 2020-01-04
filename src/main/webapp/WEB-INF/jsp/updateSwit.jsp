<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp"%>

<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <a href="/swit/${swit.id}" class="btn btn-info">Back</a>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <form action="/swit/update" method="post">
                <input name="id" type="hidden" value="${swit.id}">
                <p>Content</p>
                <input name="content" value="${swit.content}">
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <c:if test="${author}"><label>
                Input Error
            </label></c:if>
            <br/>
            <a href="/" onclick="deleteSwitById(${swit.id})" class="btn btn-danger">Delete swit</a>
        </div>
    </div>

</div>
</body>
</html>
