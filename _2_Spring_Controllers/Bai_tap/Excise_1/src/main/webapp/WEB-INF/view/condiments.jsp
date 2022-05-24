<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/24/2022
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich_Condiments</title>
  </head>
  <body>
  <form method="post" action="/sandwich">

      <h2>Sandwich Condiments</h2>

    <div role="group" aria-label="Basic checkbox toggle button group">
      <input type="checkbox" id="lettuce" autocomplete="off" value="lettuce" name="condiments">
      <label>Lettuce</label>

      <input type="checkbox" id="tomato" autocomplete="off" value="tomato" name="condiments">
      <label >Tomato</label>

      <input type="checkbox" id="mustard" autocomplete="off" value="mustard" name="condiments">
      <label>Mustard</label>

      <input type="checkbox" id="sprouts" autocomplete="off" value="sprouts" name="condiments">
      <label>Sprouts</label>
    </div>

    <div>
      <button type="submit" >Save</button>
    </div>

  </form>
  </body>
</html>
