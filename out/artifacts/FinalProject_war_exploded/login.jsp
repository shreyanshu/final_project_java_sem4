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
        <div class="container">
            <c:if test="${msg !=null}">
                <div class="bg-danger">${msg}</div>
            </c:if>
            <div class="jumbotron well-lg ">
                <div class = "row">
                    <h1 class = "text-success col-md-9 ">Login</h1>
                </div>
            </div>
            <br>
            <form class = "form-horizontal" role = "form" method="POST" action="/login">

            <div class = "form-group">
                <label class = "control-label col-sm-2">User Name: </label>

                <div class = "col-sm-5">
                    <input type = "text" class = "form-control" name="username" placeholder = "Enter User Name" required>
                </div>
            </div>

            <div class = "form-group">
                <label class = "control-label col-sm-2">Password: </label>
                <div class = "col-sm-5">
                    <input type = "password" class = "form-control " name = "password" placeholder = "Enter the password" required>
                </div>
            </div>

            <div class = "form-group ">
                <label class = "control-label col-sm-2" >Role: </label>
                <div class = "col-sm-5">
                    <select class="form-control" name= "role">
                        <option value="Admin">Admin</option>
                        <option value="Normal User">Normal User</option>
                    </select>
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
