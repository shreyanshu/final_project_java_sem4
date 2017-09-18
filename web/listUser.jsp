<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2017
  Time: 7:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ListLaptop</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="includes/navbar.jsp" %>
<div class="container">
    <div class="jumbotron well-lg ">
        <div class = "row">
            <h1 class = "text-success col-md-9 ">User List</h1>
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>SN</th>
            <th>Username</th>
            <th>Address</th>
            <th>City</th>
            <c:if test="${sessionScope.user.role == 'Admin'}">
                <th>Role</th>
                <th>Update</th>
                <th>Delete</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:set var="i" value="1" scope="page"></c:set>

        <c:forEach items="${userList}" var="user">

            <tr>
                <td>${i}</td>
                <td>${user.username}</td>
                <td>${user.address}</td>
                <td>${user.city}</td>
                <c:if test="${sessionScope.user.role == 'Admin'}">
                    <td>${user.role}</td>
                    <td><a href="/editUserForm?id=${user.id}" class="btn btn-success">update</a></td>
                    <td><a href="/deleteUser?id=${user.id}" class="btn btn-danger">delete</a></td>
                </c:if>
                <c:set var="i" value="${i+1}"/>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
