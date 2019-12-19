<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Swit ${swit.id} update</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
<a href="/swits">Back to all swits</a>
<%--@elvariable id="swit" type="lv.helloit.switter.Swit"--%>
<p>Swit update</p>
<input id="switContent" type="text" name="switContent" value="${swit.content}">
<br/>
<a id="saveChanges" href='javascript:saveDataLinkFormation()'>Save changes</a>
<br/>
<a href="/swit/${swit.id}">Back</a>

<script>
    function saveDataLinkFormation() {
        let switContent = replaceSpacesForLink($('#switContent').val());
        let finalLink = `/swit/${swit.id}/update/save/?content=` + switContent;
        $("#saveChanges").attr("href", finalLink);

        function replaceSpacesForLink(rawSwitContent) {
        return rawSwitContent.replace(/ /g,"%20");
        }
    }
</script>

</body>
</html>