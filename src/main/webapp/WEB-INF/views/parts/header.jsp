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
    <script src="/res/js/jquery-3.2.1.min.js"></script>
    <%--todo download lib--%>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="/res/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/res/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/res/css/style.css">
    <link rel="stylesheet" href="/res/font-awesome/css/font-awesome.min.css">
    <title>header</title>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top head-menu">
    <a class="navbar-brand" href="/">Navbar w/ text</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
            aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link btn " href="<c:url value="/"/>">
                    Main
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn " href="<c:url value="admin/attributes"/>">
                    Атрибуты
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn " href="<c:url value="/categorys"/>">
                    Категории товаров
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn " href="<c:url value="/categorys"/>">
                    Категории товаров
                </a>
            </li>
        </ul>
        <span class="navbar-text">
      Navbar text with an inline element
    </span>
    </div>
</nav>
<div class="content container-fluid">
