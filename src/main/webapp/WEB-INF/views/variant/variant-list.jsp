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
<h1>${attribute.name}</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th>#</th>
        <th>Attribute</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${attribute.variantList}" var="variant">
        <jsp:useBean id="variant" type="ua.ho.godex.domain.Variant"/>
        <tr>
            <th scope="row">${variant.id}</th>
            <td>${variant.name}</td>
            <td>${variant.description}</td>
            <td>
                <form method="post" action="${variant.id}/edit">
                    <button class="btn btn-secondary">
                        <i class="fa fa-edit"></i>
                    </button>
                </form>
                <form method="post" action="${variant.id}/delete">
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
        <input type="text" class="form-control" id="name" name="name" value="${newVariant.name}"/>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <input type="text" class="form-control" id="description" name="description" value="${newVariant.description}"/>
    </div>
    <input type="hidden" class="form-control" name="varId" value="${newVariant.id}"/>
    <button type="submit" class="btn btn-primary">Save</button>
</form>
<jsp:include page="../parts/footer.jsp"/>
