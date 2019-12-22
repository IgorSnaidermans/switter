<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit posting</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="scripts.js"></script>
</head>

<body>
<p>Swit creation</p>
<a href="/swits">Back to all swits</a>

<form action="/rest/swit" method="post">
    <p>Author <input name="author"></p>
    <p>Content <input name="content"></p>
    <button>Submit</button>
</form>

</body>
</html>