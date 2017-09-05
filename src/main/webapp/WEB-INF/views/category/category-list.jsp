<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 26.08.2017
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categorys</title>
</head>
<body>
<jsp:include page="../parts/header.jsp"/>
<div class="category-list">
    <ul>
        <jsp:include page="category-row.jsp"/>
    </ul>
</div>
</body>
</html>
