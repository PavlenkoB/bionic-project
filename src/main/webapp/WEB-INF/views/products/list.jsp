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
<jsp:include page="../parts/header.jsp"/>
<%--@elvariable id="category" type="ua.ho.godex.domain.Category"--%>
<form method="post" class="d-inline-block" action="<c:url value="/admin/products/add"/>">
    <input type="hidden" name="categotyId" value="${category.id}">
    <button type="submit" class="btn btn-primary">Add prod</button>
</form>
<script>
    update_tittle('${category.name}');
</script>
<h1 class="text-center">${category.name}</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
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
            <td>
                <a href="/products/${product.id}/">
                        ${product.name}
                </a>
            </td>
            <td>
                <c:forEach items="${product.variants}" var="variant">
                    <jsp:useBean id="variant" type="ua.ho.godex.domain.Variant"/>
                    <% if (variant.getAttribute().getFieldType().equals(FieldType.CHECK_BOX) && variant.getName().equals("0")) {
                    %>
                    <i title="${variant.attribute.description}"
                       class="badge badge-danger"><i class="fa fa-times"></i>${variant.attribute.name}</i>
                    <%
                    } else {
                        if (variant.getAttribute().getFieldType().equals(FieldType.CHECK_BOX)) {
                    %>
                    <i title="${variant.attribute.description}"
                       class="badge badge-success"><i class="fa fa-check"></i>${variant.attribute.name}</i>
                    <%
                    } else {
                    %>
                    <i title="${variant.attribute.description}"
                       class="badge badge-info">${variant.attribute.name}:${variant.name}</i>
                    <% }
                    }%>
                </c:forEach>
            </td>
            <td>
                <a class="btn btn-primary" href="/products/${product.id}/addToBasket">
                    <i class="fa  fa-shopping-cart "></i>add to basket
                </a>
                <form method="post" action="<c:url value="/admin/products/${product.id}/edit"/>">
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
