<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit ${swit.id} update</title>
</head>
<body>
<a href="/swits">Back to all swits</a>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
<p>Swit update</p>
<input type="text" name="switContent" value="${swit.content}">
<br/>
<a href="/swit/${swit.id}/save">Save changes</a>
<br/>
<a href="/swit/${swit.id}">Back</a>

</body>
</html>