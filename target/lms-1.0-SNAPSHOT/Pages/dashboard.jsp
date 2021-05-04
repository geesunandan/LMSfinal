<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 5/1/2021
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<body>
<%@include file="../Includes/sidebar.jsp" %>
<h1>Welcome <%= session.getAttribute("fullname")%> </h1>

</body>
</html>
