<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 10.09.2017
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<h1>Add product to ${category.name}</h1>
<form:form action="save" modelAttribute="newProduct" method="post">
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
