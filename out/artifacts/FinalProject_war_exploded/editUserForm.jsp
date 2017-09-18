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
            <h1 class = "text-success col-md-9 ">Add User</h1>
        </div>
    </div>
    <br>
    <form class = "form-horizontal" role = "form" method="POST" action="/editUser">

        <input type="hidden" name="id" value=${id}>

        <div class = "form-group">
            <label class = "control-label col-sm-2">User Name: </label>

            <div class = "col-sm-5">
                <input type = "text" class = "form-control" name="username" value="${user.username}" required>
            </div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2">Password: </label>
            <div class = "col-sm-5">
                <input type = "password" class = "form-control " name = "password" value="${user.password}" required>
            </div>
        </div>

        <div class = "form-group ">
            <label class = "control-label col-sm-2" >Role: </label>
            <div class = "col-sm-5">
                <select class="form-control" name= "role">
                    <option value="Admin" <c:if test="${user.role == 'Admin'}">selected="selected"</c:if>>Admin</option>
                    <option value="Normal User" <c:if test="${user.role == 'Normal User'}">selected="selected"</c:if>>Normal User</option>
                </select>
            </div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2">City: </label>

            <div class = "col-sm-5">
                <input type = "text" class = "form-control" name="city" value="${user.city}" required>
            </div>
        </div>

        <div class = "form-group">
            <label class = "control-label col-sm-2">Address: </label>

            <div class = "col-sm-5">
                <input type = "text" class = "form-control" name="address" value="${user.address}" required>
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
