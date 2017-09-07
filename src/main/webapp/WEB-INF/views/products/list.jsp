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
    <c:forEach items="${products}" var="product">
        <jsp:useBean id="product" type="ua.ho.godex.domain.Product"/>
        <tr>
            <th scope="row">${product.id}</th>
            <td>${product.category.name}</td>
            <td>${product.name}</td>
            <td>
                <c:forEach items="${product.variants}" var="attribute">
                    <jsp:useBean id="variant" type="ua.ho.godex.domain.Variant"/>
                    <p>${attribute.attribute.name}:${attribute.name}</p>
                </c:forEach>

            </td>
            <td>
                <form method="post" action="/admin/variants/${product.id}/edit">
                    <button class="btn btn-secondary">
                        <i class="fa fa-edit"></i>
                    </button>
                </form>
                <form method="post" action="/admin/variants/${product.id}/delete">
                    <button class="btn btn-danger">
                        <i class="fa fa-remove"></i>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--@elvariable id="newVariant" type="ua.ho.godex.domain.Variant"--%>
<form method="post" action="add">
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name"/>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name="description"/>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
<jsp:include page="../parts/footer.jsp"/>
