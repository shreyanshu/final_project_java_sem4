<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/13/2017
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="jumbotron well-lg ">
        <div class = "row">
            <h1 class = "text-success col-md-9 ">Add Laptop</h1>
        </div>
    </div>
    <br>
    <form class = "form-horizontal" role = "form" method="POST" action="/createLaptop">

        <div class = "form-group">
            <label class = "control-label col-sm-2">Brand: </label>

            <div class = "col-sm-5">
                <input type = "text" class = "form-control" name="brand" placeholder = "Enter the brand" required>
            </div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2">Model No: </label>
            <div class = "col-sm-5">
                <input type = "text" class = "form-control " name = "modelNo" placeholder = "Enter the Model No." required>
            </div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2">Price: </label>

            <div class = "col-sm-5">
                <input type = "number" class = "form-control" name="price" placeholder = "Enter the Price" required>
            </div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2">Rating: </label>

            <div class = "col-sm-5">
                <input type = "number" min="1" max="5" class = "form-control" name="rating" placeholder = "Enter the rating" required>
            </div>
        </div>

        <div class = "form-group">
            <div class = "col-sm-10 col-sm-offset-2">
                <input class="btn btn-primary" role="button" value="SUBMIT" type="submit">
            </div>
        </div>


    </form>
</div>
</body>
</body>
</html>
