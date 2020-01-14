<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="head.jsp"%>

<body>
<div class="container">
    <div class="container-fluid">
        <%@include file="navbar.jsp"%>
        <form action="/signup" method="post">
            <div class="form-group">
                <label for="emailInput">Email address</label>
                <input type="email" name="email" class="form-control" id="emailInput" aria-describedby="emailHelp"
                       placeholder="Enter email">
            </div>

            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                       placeholder="Password">
            </div>

            <div class="form-group form-check">
                Your e-mail will be visible to all registered users who would use the website.
            </div>

            <button type="submit" class="btn btn-primary">Sign Up</button>
            <button type="reset" class="btn btn-secondary">Clear</button>

        </form>
    </div>

</div>
<%@include file="footer.jsp" %>
</body>
</html>