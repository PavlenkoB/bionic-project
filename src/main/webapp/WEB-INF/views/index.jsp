<%@ page import="ua.ho.godex.dto.ProductSort" %>
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
<form method="get" action="">
    <div class="form-group">
        <label for="name">Название товара</label>
        <input type="text" id="name" name="name" value="${param.name}" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Цена:</label>
        <div class="row">
            <div class="col-12 col-sm-2">
                <label for="min" class="text-left text-sm-right">от</label>
            </div>
            <div class="col-12 col-sm-4">
                <input type="text" id="min" name="min" value="${param.min}" class="form-control"/>
            </div>
            <div class="col-12 col-sm-2">
                <label for="max" class="text-left text-sm-right">до</label>
            </div>
            <div class="col-12 col-sm-4">
                <input type="text" id="max" name="max" value="${param.max}" class="form-control"/>
            </div>
        </div>
    </div>
    <div class="form-group">
        <label for="categoryId">Category</label>
        <select class="form-control" name="categoryId" id="categoryId">
            <c:forEach varStatus="loop" var="category" items="${categorys}">
                <jsp:useBean id="category" type="ua.ho.godex.domain.Category"/>
                <option <%= (category.getId().toString().equals(request.getParameter("categoryId"))) ? "selected" : "" %>
                        value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="sort">Сортировка</label>
        <select id="sort" name="sort" class="form-control">
            <option value="<%= ProductSort.NAME_ASC.name() %>"
                    <%= ProductSort.NAME_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                алфавиту А-Я
            </option>
            <option value="<%= ProductSort.NAME_DESC.name() %>"
                    <%= ProductSort.NAME_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>По
                алфавиту Я-А
            </option>
            <option value="<%= ProductSort.PRICE_ASC.name() %>"
                    <%= ProductSort.PRICE_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>От
                дешевых к дорогим
            </option>
            <option value="<%= ProductSort.PRICE_DESC.name() %>"
                    <%= ProductSort.PRICE_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>От
                дорогих к дешевым
            </option>
        </select>
    </div>
    <button type="submit" class="btn btn-info">
        <i class="fa fa-search"></i>Search
    </button>
</form>
<%-- Paginator --%>
<nav>
    <c:set var="page" value="${param.page != null ? param.page : 1}"/>
    <c:set var="query"
           value="${pageContext.request.queryString != null ? pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
    <ul class="pagination">
        <c:forEach begin="1"
                   end="${productCount % pageSize == 0 ? productCount / pageSize : productCount / pageSize + 1 }"
                   varStatus="loop">
            <c:choose>
                <c:when test="${page == loop.index}">
                    <li class="page-item active">
                        <span class="page-link">${loop.index}</span>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a href="<c:url value="?${query}&page=${loop.index}"/>" class="page-link">
                                ${loop.index}
                        </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ul>
</nav>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>Category</th>
        <th>Product</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}" varStatus="iterator">
        <tr>
            <jsp:useBean id="product" type="ua.ho.godex.domain.Product"/>
            <td>
                    ${iterator.index}
            </td>
            <td>

                <a href="<c:url value="/categorys/${product.category.id}/"/>">
                        ${product.category.name}
                </a>
            </td>
            <td>

                <a href="<c:url value="/products/${product.id}/"/>">
                        ${product.name}
                </a>
            </td>
            <td>
                    ${product.price}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
${session.getAttribute("currentOrder")}
<jsp:include page="parts/footer.jsp"/>
