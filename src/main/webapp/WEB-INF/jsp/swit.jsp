<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit ${swit.id}</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container">
<a href="/" class="btn btn-info">Back</a>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
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
<!-- BOOTSTRAP -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<!-- BOOTSTRAP -->
</div>
</body>
</html>
