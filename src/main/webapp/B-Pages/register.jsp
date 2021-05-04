<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 5/3/2021
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div class="main">
    <p class="register" align="center">Register</p>
    <form class="form1" action="books?page=register" method="post">
        <input class="bn " id = "booksname" name = "booksname" type="text" align="center" placeholder="Enter Booksname">
        <input class="auth" id = "author" name="author" type="text" align="center" placeholder="Enter Books Author">
        <input class="gen" id = "genre" name="genre" type="text" align="center" placeholder="Enter Genre">
        <input class="rack" id = "rackno" name="rackno" type="text" align="center" placeholder="Enter Racknumber">
        <input class="submit" type="submit" value="Register">
        </br>
    </form>
</div>


</body>
</html>
