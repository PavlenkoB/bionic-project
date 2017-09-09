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
<jsp:include page="../parts/header.jsp"/>
<%--@elvariable id="categorys" type="ua.ho.godex.domain.Category"--%>
<form method="post" class="d-inline-block" action="add">
    <div class="form-group">
        <label for="category">Category</label>
        <select class="form-control" id="category" name="categoryId">
            <c:forEach items="${categorys}" var="category">
                <jsp:useBean id="category" type="ua.ho.godex.domain.Category"/>
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Category</th>
        <th>Name</th>
        <th>Attribute</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${category.productList}" var="product">
        <jsp:useBean id="product" type="ua.ho.godex.domain.Product"/>
        <tr>
            <th scope="row">${product.id}</th>
            <td>${product.category.name}</td>
            <td>${product.name}</td>
            <td>
                <c:forEach items="${product.variants}" var="variant">
                    <jsp:useBean id="variant" type="ua.ho.godex.domain.Variant"/>
                    <p>${variant.attribute.name}:${variant.name}</p>
                </c:forEach>
            </td>
            <td>
                <form method="post" action="${product.id}/edit">
                    <button class="btn btn-secondary">
                        <i class="fa fa-edit"></i>
                    </button>
                </form>
                <form method="post" action="${product.id}/delete">
                    <button class="btn btn-danger">
                        <i class="fa fa-remove"></i>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="../parts/footer.jsp"/>
