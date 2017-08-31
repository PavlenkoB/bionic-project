<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<ul>
    <c:forEach items="${attributes}" var="attribute">
        <jsp:useBean id="attribute" type="ua.ho.godex.domain.Attribute"/>
        <li>
                ${attribute.name}
            <ul>
                <c:forEach items="${attribute.variantList}" var="variant">
                    <jsp:useBean id="variant" type="ua.ho.godex.domain.Variant"/>
                    <li>
                        ${variant.name}(${variant.description})
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>
</body>
</html>
