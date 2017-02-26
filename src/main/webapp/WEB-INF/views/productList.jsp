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

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>


            <p class="lead">Check out all available products</p>

        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Manufacturer</th>
                <th>Discription</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>

                    <td><img src="#" alt="image"/></td>
                    <td>${product.productManufacturer}</td>

                    <td>${product.productName}</td>
                    <td>${product.productCondition}</td>
                    <td>€${product.productPrice}</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${product.productID}"/>"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>


                </tr>
            </c:forEach>
        </table>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
