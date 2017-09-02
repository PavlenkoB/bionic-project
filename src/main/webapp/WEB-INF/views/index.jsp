<html>
<head>
    <title>index</title>
    <link rel="icon" type="image/x-icon" href="find-favicon.ico">
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 23.08.2017
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="parts/header.jsp"/>
${users.size()}
<c:forEach var="user" items="${users}">
    <jsp:useBean id="user" type="ua.ho.godex.domain.User"/>
    <ul>
        <li>${user.name}</li>
        <ul>
            <c:forEach var="product" items="${user.ownProducts}">
                <jsp:useBean id="product" type="ua.ho.godex.domain.Product"/>
                <li>
                        ${product.name}
                </li>
            </c:forEach>
        </ul>
    </ul>


</c:forEach>
</body>
</html>
