<%--
  Created by IntelliJ IDEA.
  User: Alan Doyle
  Date: 05/02/2017
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alan Doyle
  Date: 28/01/2017
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator Page</h1>


            <p class="lead">This is the Admin Page</p>

        </div>

        <h3>

            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>

        </h3>
        <p>Here you can view , check and modify the products in stock.</p>

        <%@include file="/WEB-INF/views/template/footer.jsp" %>

