<%@ page import="ua.ho.godex.domain.FieldType" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>category</th>
            <th>Name</th>
            <th>Type</th>
            <th>Description</th>
            <th>Variants</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${attributes}" var="variant">
            <jsp:useBean id="attribute" type="ua.ho.godex.domain.Attribute"/>
            <tr>
                <th scope="row">${variant.id}</th>
                <td>${variant.category.name}</td>
                <td>${variant.name}</td>
                <td>${variant.fieldType}</td>
                <td>${variant.description}</td>
                <td>
                    <pre>${variant.variantsInString}</pre>
                    <% if (attribute.getFieldType() == FieldType.DROP_BOX) {%>
                    <form method="get" action="/admin/variants/${variant.id}/">
                        <button class="btn btn-secondary">
                            <i class="fa fa-edit"></i>
                        </button>
                    </form>
                    <% } %>
                </td>
                <td>
                    <form method="post" action="/admin/attributes/${variant.id}/edit">
                        <button class="btn btn-secondary">
                            <i class="fa fa-edit"></i>
                        </button>
                    </form>
                    <form method="post" action="/admin/attributes/${variant.id}/delete">
                        <button class="btn btn-danger">
                            <i class="fa fa-remove"></i>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--@elvariable id="newAttribute" type="ua.ho.godex.domain.Attribute"--%>
    <form:form modelAttribute="newAttribute" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <form:input type="text" class="form-control" id="name" path="name"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <form:input type="text" class="form-control" id="description" path="description"/>
        </div>
        <div class="form-group">
            <label for="fieldtype">FieldType</label>
            <form:select id="fieldtype" path="fieldType" class="form-control">
                <c:forEach items="${fieldtypes}" var="fieldtype">
                    <jsp:useBean id="fieldtype" type="ua.ho.godex.domain.FieldType"/>
                    <form:option value="${fieldtype.name()}"/>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <label for="categoryId">FieldType</label>
            <select id="categoryId" name="categoryId" class="form-control">
                <c:forEach items="${categorys}" var="category">
                    <jsp:useBean id="category" type="ua.ho.godex.domain.Category"/>
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form:form>
</ul>
</body>
</html>
