<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 03.09.2017
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="categorys" type="ua.ho.godex.domain.Category"--%>
<c:forEach varStatus="loop" var="node" items="${categorys}">
    <jsp:useBean id="node" type="ua.ho.godex.domain.Category"/>
    <li>
        <a>${node.name}</a>
        <c:if test="${node.children.size() > 0}">
            <ul>
                <c:set var="categorys" value="${node.children}" scope="request"/>
                <jsp:include page="node.jsp"/>
            </ul>
        </c:if>
    </li>
</c:forEach>
