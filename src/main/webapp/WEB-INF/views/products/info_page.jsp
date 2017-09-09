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
<script>
    update_tittle('${product.name}');
</script>
<%--@elvariable id="category" type="ua.ho.godex.domain.Category"--%>
<table class="table table-striped">
    <a class="btn btn-info" href="/categorys/${product.category.id}">
        <i class="fa fa-chevron-left"></i> ${product.category.name}
    </a>
    <a class="btn btn-primary" href="/products/${product.id}/addToBasket">
        <i class="fa  fa-shopping-cart "></i>add to basket
    </a>
    <p>
    <div class="img-placeholder">
        <img src="/">
    </div>
    <p>
        <b>Name:</b> ${product.name}
    </p>
    <p>
        <b>Count:</b> ${product.count}
    </p>
    <p>
        <b>description:</b> ${product.description}
    </p>
    <p>
        <b>price:</b> ${product.price}
    </p>
    <p>
        <b>variants:</b>
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
    </p>
</table>
<jsp:include page="../parts/footer.jsp"/>
