<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 23.08.2017
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <link rel="icon" type="image/x-icon" href="find-favicon.ico">
</head>
<body>

<jsp:include page="parts/header.jsp"/>
<c:forEach items="${users}" var="user">
    <jsp:useBean id="user" type="ua.ho.godex.domain.User"/>
    <br>
    ${user.printInfo}

</c:forEach>

</body>
</html>
