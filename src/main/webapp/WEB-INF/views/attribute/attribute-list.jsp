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
            <th>Name</th>
            <th>Description</th>
            <th>Variants</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${attributes}" var="attribute">
            <jsp:useBean id="attribute" type="ua.ho.godex.domain.Attribute"/>
            <tr>
                <th scope="row">${attribute.id}</th>
                <td>${attribute.name}</td>
                <td>${attribute.description}</td>
                <td>
                    <pre>${attribute.variantsInString}</pre>
                </td>
                <td>
                    <button class="btn btn-secondary">
                        <a>
                            <i class="fa fa-edit"></i>
                        </a>
                    </button>

                    <button class="btn btn-danger">
                        <a href="/admin/attributes/${attribute.id}/delete">
                            <i class="fa fa-remove"></i>
                        </a>
                    </button>
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
        <button type="submit" class="btn btn-primary">Add</button>
    </form:form>
</ul>
</body>
</html>
