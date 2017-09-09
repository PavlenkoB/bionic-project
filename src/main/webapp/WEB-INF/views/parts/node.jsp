<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 03.09.2017
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="categorysMenu" type="ua.ho.godex.domain.Category"--%>
<c:forEach varStatus="loop" var="menuNode" items="${categorysMenu}">
    <jsp:useBean id="menuNode" type="ua.ho.godex.domain.Category"/>
    <li>
        <a href="/categorys/${menuNode.id}/">${menuNode.name}</a>
        <c:if test="${menuNode.children.size() > 0}">
            <ul>
                <c:set var="categorysMenu" value="${menuNode.children}" scope="request"/>
                <jsp:include page="node.jsp"/>
            </ul>
        </c:if>
    </li>
</c:forEach>
