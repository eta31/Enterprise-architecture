<%--
  Created by IntelliJ IDEA.
  User: 986215
  Date: 5/16/2018
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>User details</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>One of our People</h1>
            <p>An important contributor to our Community!!!</p>
        </div>

        <div class="pull-left">
            <h3>${SpecialBlurb}</h3>
        </div>
        <a href="<spring:url value="/users/add" />"
           class="btn btn-danger btn-mini pull-right">Add a new one</a> <br>
    </div>
</section>

<section class="container">
    <div class="row">
        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
            <div class="thumbnail">
                <div class="caption">
                    <h3>First Name - ${user.firstName}</h3>
                    <h3>Last Name - ${user.lastName}</h3>
                    <p>Email - ${user.email}</p>
                    <%-- <p>User Name - ${user.userCredentials.userName}</p> --%>

                </div>
            </div>
        </div>

    </div>
</section>
</body>
</html>
