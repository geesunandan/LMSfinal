<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 5/3/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<div id="wrapper">

    <%--    <%@include file=""%>--%>
    <div class="container">
        <input type="hidden" name="id" value="${user.id}">

        <h1> Admin Registration Form</h1>
        <form action="user?page=editUser" method="post">
            <input type="hidden" name="id" value="${user.id}">
            <h3> Step 1:</h3>
            <div>
                <h4>Full Name:</h4>
                <input type="text" name="fullname" value="${user.fullname}" placeholder="Enter Full Name">
                <h4>Address:</h4>
                <input type="text" name="address" value="${user.address}" placeholder="Enter Address">
                <h4>Phonenumber:</h4>
                <input type="text" name="phonenumber" value="${user.phonenumber}" placeholder="Enter Phonenumber">

            </div>

            <h3> Step 2 :</h3>
            <div>
                <h4>Username:</h4>
                <input type="text" name="username" value="${user.username}" placeholder="Enter a username">
                <h4>Password:</h4>
                <input type="password" name="password" value="${user.password}" placeholder="Enter a password">
            </div>

            <input type="submit" value="Update User" name="submit">
            <input type="reset" value="Reset" name="reset">

        </form>
    </div>
</div>
</body>
</html>
