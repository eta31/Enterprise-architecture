<%--
  Created by IntelliJ IDEA.
  User: 986215
  Date: 5/16/2018
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Our People</h1>
            <p>All of the contributors to our Community!!!</p>

            <div class="pull-left">
                <h3>${SpecialBlurb}</h3>
            </div>
        </div>
        <c:if test="${not empty user }">
            <a href="<spring:url value="/users/add" />"
               class="btn btn-danger btn-mini pull-right">Add a new one</a>
            <br>
            <spring:url var="logoutUrl" value="/logout"/>
            <form action="${logoutUrl}" method="get">
                <sec:csrfInput/>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10 ">
                        <input type="submit" class="btn btn-primary btn-danger pull-right"
                               value="Logout"/>
                    </div>
                </div>

            </form>
        </c:if>

    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${users}" var="user">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h4>First Name - ${user.firstName}</h4>
                        <h4>
                            Last Name - ${user.lastName} <a
                                href="<spring:url value="/users/${user.id}" />"
                                class="btn btn-primary  btn-mini  ">View</a>
                        </h4>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

</body>
</html>
