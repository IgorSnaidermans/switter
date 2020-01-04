<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp" %>

<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <br/>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">Create swit</h5>
            <p class="card-text">
                <form action="/swit" method="post" onsubmit="window.location.href='/'">
            <p>Author <input name="author" value="Template"></p>
            <p>Content <input name="content" value="Template"></p>
            <button class="btn badge-primary">Submit</button>
            </form></p>
        </div>
    </div>
</div>
</body>
</html>