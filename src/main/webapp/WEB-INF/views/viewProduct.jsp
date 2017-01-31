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
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>


            <p class="lead">Here is the detailed information of the product</p>

        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="#" alt="image" style="width: 100%; height:300px"/>
                </div>

                <div class="col-md-5">
                    <h3>Product Name</h3>
                    <p>Product Description</p>
                    <p>Manufacturer</p>
                    <p>Category</p>
                    <p>Condition</p>
                    <p>Price</p>
                </div>

            </div>
        </div>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
