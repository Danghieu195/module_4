<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2022
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sandwich_Condiments</title>
</head>
<body>
<form method="post" action="/sandwich" >

    <div >
        <h2>Sandwich Condiments</h2>
    </div>

    <div role="group" aria-label="Basic checkbox toggle button group">
        <input type="checkbox"  id="lettuce" autocomplete="off" value="lettuce" name="condiments">
        <label >Lettuce</label>

        <input type="checkbox"  id="tomato" autocomplete="off" value="tomato" name="condiments">
        <label  for="tomato">Tomato</label>

        <input type="checkbox"  id="mustard" autocomplete="off" value="mustard" name="condiments">
        <label  for="mustard">Mustard</label>

        <input type="checkbox"  id="sprouts" autocomplete="off" value="sprouts" name="condiments">
        <label  for="sprouts">Sprouts</label>
    </div>

    <div>
        <p id="disabledInput" type="text" value="The condiments that you selected are
            <c:forEach var="condiment" items="${condiments}">
                <c:out value=" ${condiment}"/>
            </c:forEach>" disabled>
    </div>

    <div>
        <button type="submit">Save</button>
    </div>
</form>


</body>
</html>
