<%@ page import="ua.ho.godex.domain.FieldType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 07.09.2017
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<h1>Add product to ${category.name}</h1>
<form:form action="/admin/products/save" modelAttribute="newProduct" method="post">
    <c:forEach items="${category.attributes}" var="attribute">
        <jsp:useBean id="attribute" type="ua.ho.godex.domain.Attribute"/>
        <div class="form-group">
            <label for="${attribute.id}">${attribute.name}</label>
            <% if (attribute.getFieldType().equals(FieldType.DROP_BOX) || attribute.getFieldType().equals(FieldType.CHECK_BOX)) {
                //todo need help
            %>
            <select class="form-control" id="${attribute.id}" name="attr-${attribute.id}">
                <c:forEach items="${attribute.variantList}" var="variant">
                    <option value="${variant.id}">${variant.name}</option>
                </c:forEach>
            </select>
            <%
            } else if (attribute.getFieldType().equals(FieldType.CHECK_BOX)) {
            %>
            <input class="checkbox" id="${attribute.id}" type="checkbox" checked name="attr-${attribute.id}">
            <%
            } else {
            %>
            %>
            <%
                }
            %>
        </div>
    </c:forEach>
    <div class="form-group">
        <label for="name">Name</label>
        <form:input type="text" class="form-control" id="name" path="name"/>
    </div>
    <input type="hidden" class="form-control" name="category-id" value="${category.id}"/>
    <div class="form-group">
        <label for="description">description</label>
        <form:input type="text" class="form-control" id="description" path="description"/>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form:form>
<jsp:include page="../parts/footer.jsp"/>

