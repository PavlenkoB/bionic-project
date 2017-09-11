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
<c:choose>
    <c:when test="${order.products.size()>0}">


        <p>
            Sum:${order.totalAmount}
        </p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Prod name</th>
                <th>Price</th>
                <th>action</th>
            </tr>
            </thead>
            <c:forEach var="product" items="${order.products}" varStatus="iterator">
                <tr>
                    <td>
                            ${iterator.index}
                    </td>
                    <td>
                        <a href="/products/${product.id}/">
                                ${product.name}
                        </a>
                    </td>
                    <td>
                            ${product.price}
                    </td>
                    <td>
                        <form method="post" action="delFromBasket">
                            <input type="hidden" value="${iterator.index}" name="indexInOrder">
                            <button class="btn btn-danger" title="Delelete product form basket">
                                <i class="fa fa-times"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <form method="post" action="saveBasket">
            <button type="submit">
                <i class="fa fa-money"></i>
                Save order
            </button>
        </form>
        <form method="post" action="cleanBasket">
            <button type="submit">
                <i class="fa fa-trash"></i>
                Claen Basket
            </button>
        </form>
    </c:when>
    <c:otherwise>
        <h2>
            Basket is empty
        </h2>
    </c:otherwise>
</c:choose>
<jsp:include page="../parts/footer.jsp"/>