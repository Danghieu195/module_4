<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2022
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form method="post" action="/dictionary">
    <div>
        <label for="engWord" >English Word: </label>
        <input type="text"id="engWord" name="engWord" value="${engWord}">
    </div>

    <div>
        <label>Vietnamese Word: </label>
        <input type="text" value="${vieWord}">
    </div>

</form>
</body>
</html>
