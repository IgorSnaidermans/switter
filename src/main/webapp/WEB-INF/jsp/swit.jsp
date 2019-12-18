<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit ${swit.id}</title>
</head>
<body>
<a href="/swits">Back</a>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>

<p>Swit id: ${swit.id}</p>
<p>Swit author: ${swit.author}</p>
<br/>
<p>Content</p>
<p>${swit.content}</p>
<br/>
<p>Published: ${swit.publishDate}</p>
<c:if test="${!swit.publishDate.equals(swit.lastUpdateDate)}">
<p>Modified: ${swit.lastUpdateDate}</p>
</c:if>
<a href="/swit/${swit.id}/update">Update this swit</a>
<br/>
<a href="/swit/${swit.id}/delete">Delete this swit</a>

</body>
</html>
