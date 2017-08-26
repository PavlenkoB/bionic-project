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
    <title>Attributes</title>
</head>
<body>

<jsp:include page="../parts/header.jsp"/>
<c:forEach items="${attributes}" var="attribute">
    <jsp:useBean id="attribute" type="ua.ho.godex.domain.Attribute"/>
    <br>
    ${attribute.name}

</c:forEach>
</body>
</html>
