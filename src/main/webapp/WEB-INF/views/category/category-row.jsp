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
<c:forEach varStatus="loop" var="category" items="${categorys}">
    <jsp:useBean id="category" type="ua.ho.godex.domain.Category"/>
    <li>
        <a>
            (${category.order})
            <input type="hidden" value="${category.order}"/>
                ${category.name}
            <div class="menu-item-actions">
                <form method="post" action="${category.id}/up">
                    <button class="btn btn-secondary">
                        <i class="fa fa-2x fa-arrow-up"></i>
                    </button>
                </form>
                <form method="post" action="${category.id}/down">
                    <button class="btn btn-secondary">
                        <i class="fa fa-2x fa-arrow-down"></i>
                    </button>
                </form>
                <form method="post" action="${category.id}/edit">
                    <button class="btn btn-info">
                        <i class="fa fa-2x fa-edit"></i>
                    </button>
                </form>
                <form method="post" action="${category.id}/delete">
                    <button class="btn btn-danger">
                        <i class="fa fa-2x fa-remove"></i>
                    </button>
                </form>

            </div>
        </a>
        <c:if test="${category.children.size() > 0}">
            <ul>
                <c:set var="categorys" value="${category.children}" scope="request"/>
                <jsp:include page="category-row.jsp"/>
            </ul>
        </c:if>
    </li>
</c:forEach>


