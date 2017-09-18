<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/14/2017
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <b><a class="navbar-brand">LAPTOP</a></b>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/listUsers">List Users</a></li>
            <li><a href="/listLaptops">List Laptops</a></li>
            <c:if test="${sessionScope.user.role == 'Admin'}">
                <li><a href="/addUser">Add User</a></li>
                <li><a href="/addLaptop">Add Laptop</a></li>
            </c:if>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><b><a  class="navbar-brand" href="/logout">Logout</a></b></li>
        </ul>
    </div>
</nav>