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
        <i class="fa fa-arrow-left"></i> ${product.category.name}
    </a>
    <a>
        add to baske need to do
    </a>
    <p>
        <b>Name:</b> ${product.name}
    </p>
</table>
<jsp:include page="../parts/footer.jsp"/>
