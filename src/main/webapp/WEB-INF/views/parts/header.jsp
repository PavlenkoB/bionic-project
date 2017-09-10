<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: godex
  Date: 25.08.2017
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" type="img/ico" href="/res/favicon.ico">
    <script src="/res/js/jquery-3.2.1.min.js"></script>
    <%--todo download lib--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="/res/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/res/css/style.css">
    <link rel="stylesheet" href="/res/font-awesome/css/font-awesome.min.css">
    <title>Supliers</title>
    <script>
        function update_tittle(text) {
            document.title = text + '-' + document.title;
        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg  navbar-dark bg-dark fixed-top head-menu">
    <a class="navbar-brand" href="/">
        <i class="fa fa-beer fa-3x"></i>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link btn btn-secondary " href="<c:url value="/orders/basket/"/>">
                    <jsp:include page="basket.jsp"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary " href="<c:url value="/"/>">
                    Main
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary " href="<c:url value="/attributes/"/>">
                    Атрибуты
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary" href="<c:url value="/categorys/"/>">
                    Категории товаров
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary" href="<c:url value="/users/"/>">
                    Users
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary" href="<c:url value="/products/"/>">
                    Products
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary" href="<c:url value="/orders/"/>">
                    Orders
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-secondary" href="<c:url value="/users/register/"/>">
                    Register
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="categorys-menu">
    <ul class="category-menu">
        <jsp:include page="node.jsp"/>
    </ul>
</div>
<div class="content container-fluid">

