<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 5/3/2021
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<table width="100%">
    <tr>
        <th>Fullname</th>
        <th>Address</th>
        <th>Phonenumber</th>
        <th>Username</th>
        <th>Password</th>
    </tr>


        <c:forEach items="${userList}" var="user">
        <tr>
            <td> ${user.fullname}</td>
            <td> ${user.address}</td>
            <td> ${user.phonenumber}</td>
            <td> ${user.username}</td>
            <td> ${user.password}</td>
        </tr>
        </c:forEach>
    <tr>
        <td> <a href="user?page=newUsers"> Add User </a> </td>
    </tr>
</table>

</body>
</html>
