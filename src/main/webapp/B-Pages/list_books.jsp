<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 5/3/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books List</title>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<body>
<table width="100%">
    <tr>
        <th>Booksname</th>
        <th>Author</th>
        <th>Genre</th>
        <th>Rack Number</th>
    </tr>


    <c:forEach items="${booksList}" var="books">
        <tr>
            <td> ${books.booksname}</td>
            <td> ${books.author}</td>
            <td> ${books.genre}</td>
            <td> ${books.rackno}</td>
            <td> <a href="books?page=deleteBook&id=${books.id}"> Delete</a> </td>
            <td> <a href="books?page=bookEdit&id=${books.id}"> Edit</a> </td>

        </tr>
    </c:forEach>
    <tr>
        <td><a href="books?page=newBooks"> Add Books </a></td>
    </tr>
</table>

</body>
</html>
