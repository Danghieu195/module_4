<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2022
  Time: 2:12 PM
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
        <label>English Word: </label>
        <input type="text" id="engWord" name="engWord">
    </div>

    <button type="submit">Translate</button>
</form>
</body>
</html>
