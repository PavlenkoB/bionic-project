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
<ul>
    <c:forEach var="product" items="${products}">
        <jsp:useBean id="product" type="ua.ho.godex.domain.Product"/>
        <li>
            <a href="<c:url value="/products/${product.id}/"/>">
                    ${product.category.name}-> ${product.name}
            </a>
        </li>
    </c:forEach>
</ul>
${session.getAttribute("currentOrder")}
<jsp:include page="parts/footer.jsp"/>
