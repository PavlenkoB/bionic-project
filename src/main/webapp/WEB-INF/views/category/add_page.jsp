<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 10.09.2017
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<%--@elvariable id="editedCategory" type="ua.ho.godex.domain.Category"--%>
<%--@elvariable id="categorys" type="java.util.List<ua.ho.godex.domain.Category>"--%>
<form:form action="save" modelAttribute="editedCategory" method="post">
    <div class="form-group">
        <label for="name">Name</label>
        <form:input type="text" class="form-control" id="name" path="name"/>
    </div>
    <div class="form-group">
        <label for="order">order</label>
        <form:input type="text" class="form-control" id="order" path="order"/>
    </div>
    <form:input type="hidden" class="form-control" name="id" path="id" value="${editedCategory.id}"/>
    <select name="parentCategoryId">
        <option value=""></option>
        <c:forEach varStatus="loop" var="category" items="${categorys}">
            <jsp:useBean id="category" type="ua.ho.godex.domain.Category"/>
            <option <%= (category.getId().toString().equals(request.getParameter("categoryId"))) ? "selected" : "" %>
                    value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br>
    <button type="submit" class="btn btn-primary">Save</button>
</form:form>
<jsp:include page="../parts/footer.jsp"/>
