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
            <h1>Add Product</h1>


            <p class="lead">Fill in the below information to add a product:</p>

        </div>

        <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" commandName="product">
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" id="name" class="form-Control"/>

        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="game"/>Game Fishing</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="course"/>Course Fishing</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="clothing"/>Clothing</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="footware"/>Footware</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="accessory"/>Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>

        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" id="price" class="form-Control"/>

        </div>
        <div class="form-group">
        <label for="condition">condition</label>
        <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="New"/>New</label>
        <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="Used"/>Used</label>

        </div>
        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active"/>Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive"/>Out Of Production</label>

        </div>
        <div class="form-group">
            <label for="unitsInStock">Units In Stock</label>
            <form:input path="unitInStock" id="unitsInStock" class="form-Control"/>

        </div>
        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>

        </div>
        <br><br>
        <input type="submit" value="submit" class="btn btn-primary"/>
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-primary">Cancel</a>



        </form:form>


        <%@include file="/WEB-INF/views/template/footer.jsp" %>
