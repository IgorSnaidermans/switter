<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit ${swit.id} update</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
<a href="/swit/${swit.id}">Back</a>

<form action="/rest/swit/update" method="post">
    <input name="id" type="hidden" value="${swit.id}">
    <p>Content</p>
    <input name="content" value="${swit.content}">
    <button type="submit">Submit</button>
</form>

</body>
</html>
