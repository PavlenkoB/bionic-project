<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 25.08.2017
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
</head>
<body>
<ul style="display: inline;">
    <li>
        <a href="<c:url value="/"/>">
            Main
        </a>
    </li>
    <li>
        <a href="<c:url value="/attributes"/>">
            Attributes
        </a>
    </li>
</ul>
</body>
</html>
