<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit ${swit.id}</title>
</head>
<body>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
<p>${swit.id}</p>
<p>${swit.author}</p>
<p>${swit.content}</p>
<p>${swit.publishDate}</p>
<p>${swit.lastUpdateDate}</p>
</body>
</html>
