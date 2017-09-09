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
<%--@elvariable id="newUser" type="ua.ho.godex.domain.User"--%>
<form:form modelAttribute="newUser" method="post">
    <form:input path="id" type="hidden"/>
    <div class="form-group">
        <label for="name">Name</label>
        <form:input type="text" class="form-control" id="name" path="name"/>
    </div>
    <div class="form-group">
        <label for="email">email</label>
        <form:input type="text" class="form-control" id="email" path="email"/>
    </div>
    <div class="form-group">
        <label for="telephone">telephone</label>
        <form:input type="text" class="form-control" id="telephone" path="telephone"/>
    </div>
    <div class="form-group">
        <label for="password">password</label>
        <form:input type="text" class="form-control" id="password" path="password"/>
    </div>
    <button type="submit" class="btn btn-primary">Save</button>
</form:form>
<jsp:include page="../parts/footer.jsp"/>