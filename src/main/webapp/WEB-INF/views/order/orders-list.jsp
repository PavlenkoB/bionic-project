<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <th>Actions</th>
        <th>Date-open</th>
        <th>Date-close</th>
        <th>Descripiton</th>
        <th>Sum</th>
        <th>User data</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>
                    ${order.id}
                <div>
                    <form action="${order.id}/delete">
                        <button class="btn btn-outline-danger">
                            <i class="fa fa-times"></i>delete
                        </button>
                    </form>
                    <form action="${order.id}/close">
                        <button class="btn btn-outline-primary">
                            <i class="fa fa-truck"></i>order delivered
                        </button>
                    </form>
                </div>
            </td>
            <td>${order.localDateTimeOpen}</td>
            <td>${order.localDateTimeClosed}</td>
            <td>${order.description}</td>
            <td>${order.totalAmount}</td>
            <td>
                    ${order.user.name}
                    ${order.user.email}
                    ${order.user.telephone}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<jsp:include page="../parts/footer.jsp"/>
