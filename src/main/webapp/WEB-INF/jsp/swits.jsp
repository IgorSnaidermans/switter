<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Latest swits</title>
    <link href="/styles.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="scripts.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <%--@elvariable id="swits" type="java.util.List"--%>
    <%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
    <c:if test="${swits.isEmpty()}">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">No swits, be the first one!</h5>
                <a id="postSwitButton" href="/postSwit" class="btn btn-primary">Post new Swit</a>
            </div>
        </div>
    </c:if>

    <c:forEach items="${swits}" var="swit">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">${swit.author}</h5>
                <p class="card-text">${swit.content}</p>
                <a href="/swit/${swit.id}" class="btn btn-primary">More information</a>
                <a href="/" onclick="deleteSwitById(${swit.id})" class="btn btn-danger">Delete swit</a>
            </div>
        </div>
    </c:forEach>
    <br/>
    <c:if test="${!swits.isEmpty()}">
        <a id="postSwitButton" href="/postSwit" class="btn btn-primary">Post new Swit</a>
        <a href="/" onclick="deleteAllSwits()" class="btn btn-danger">Delete all swits</a>
    </c:if>

</div>
<!-- BOOTSTRAP -->
<script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<!-- BOOTSTRAP -->

</body>
</html>