<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2022
  Time: 12:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form method="post" action="/calculate">

    <h2>Calculator</h2>

    <div>
        <label>First Operand: </label>
        <input type="text" id="firstOperand" name="firstOperand">
    </div>

    <div>
        <label>Second Operand: </label>
        <input type="text" id="secondOperand" name="secondOperand">
    </div>

    <div>
        <button type="submit" value="Addition" name="calculate">Addition</button>
        <button type="submit" value="Subtraction" name="calculate">Subtraction</button>
        <button type="submit" value="Multiplication" name="calculate">Multiplication</button>
        <button type="submit" value="Division" name="calculate">Division</button>
    </div>

</form>

</body>
</html>
