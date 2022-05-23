<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/23/2022
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange</title>
</head>
<h1>Exchange Money</h1>
<body>
<form action="/exchange" method="post">
    <label>
        USD
        <input name="usd" type="text" id = "usd">
    </label>
    <br>
    <label>
        Ratio
        <input name="ratio" type="text" id="ratio">
    </label>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
