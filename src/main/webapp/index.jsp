<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign in</title>
</head>

<body>
<div class="main">
    <p class="sign" align="center">Login</p>
    <input type="hidden" name="page" value="login">
    <form class="form1" action="user" method="post">
        <input type="hidden" name="page" value="login">
        <input class="un " type="text" name = "username" align="center" placeholder="Username">
        <input class="pass" type="password" name="password" align="center" placeholder="Password">
        <input  class="submit" type ="submit" value="Login" align="center">
        <p class="register" align="center"><a href="user?page=newUsers">Register?</a></p>



    </form>
</div>
</body>
</html>