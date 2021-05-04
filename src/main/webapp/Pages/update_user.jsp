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
<body>
<div id="wrapper">

    <%--    <%@include file=""%>--%>
    <div class="container">
        <input type="hidden" name="id" value="${books.id}">

        <h1> Books Registration Form</h1>
        <form action="books?page=editBook" method="post">
            <input type="hidden" name="id" value="${books.id}">
            <h3> Step 1:</h3>
            <div>
                <h4>Books Name:</h4>
                <input type="text" name="booksname" value="${books.booksname}" placeholder="Enter BooksName">
                <h4>Author:</h4>
                <input type="text" name="author" value="${books.author}" placeholder="Enter Authors name">

            </div>

            <h3> Step 2 :</h3>
            <div>
                <h4>Genre:</h4>
                <input type="text" name="genre" value="${books.genre}" placeholder="Enter Genre">
                <h4>Rack Number:</h4>
                <input type="text" name="rackno" value="${books.rackno}" placeholder="Enter Rack number">
            </div>

            <input type="submit" value="Update Book" name="submit">
            <input type="reset" value="Reset" name="reset">

        </form>
    </div>
</div>
</body>
</html>
