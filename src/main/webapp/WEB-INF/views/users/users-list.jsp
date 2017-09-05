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
    <title>users</title>
</head>
<body>
<jsp:include page="../parts/header.jsp"/>
<ul>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>email</th>
            <th>password</th>
            <th>role</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" type="ua.ho.godex.domain.User"/>
            <tr>
                <th scope="row">${user.id}</th>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td>
                    <form method="post" action="/admin/users/${user.id}/edit">
                        <button class="btn btn-secondary">
                            <i class="fa fa-edit"></i>
                        </button>
                    </form>
                    <form method="post" action="/admin/users/${user.id}/delete">
                        <button class="btn btn-danger">
                            <i class="fa fa-remove"></i>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</ul>
</body>
</html>
