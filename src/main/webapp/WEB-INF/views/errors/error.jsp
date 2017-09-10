<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 05.09.2017
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
<a href="/">Go to main page</a>
<h1>ERROR</h1>
<pre>
<c:forEach items="${errorMap}" var="error">
    ${error.key}->${error.value}
</c:forEach>
</pre>
</body>
</html>
