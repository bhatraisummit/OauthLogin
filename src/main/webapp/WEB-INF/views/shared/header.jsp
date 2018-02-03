<%-- 
    Document   : header
    Created on : Jan 28, 2018, 8:32:39 PM
    Author     : Sumit
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${SITE_URL}/static/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${SITE_URL}/static/jquery.min.js" type="text/javascript"></script>
        <title>Welcome Page</title>
    </head>
    <body>
        <ul class="nav nav-tabs" id="menu">
            <li role="presentation" class="active"><a href="${SITE_URL}">Home</a></li>
            <li role="presentation"><a href="${SITE_URL}/admin/project">Projects</a></li>
            <li role="presentation"><a href="${SITE_URL}/admin/clients">Clients</a></li>
            <li role="presentation"><a href="${SITE_URL}/admin/skills">Skills</a></li>
            <li role="presentation"><a href="${SITE_URL}/admin/task">Tasks</a></li>
            <li role="presentation"><a href="${SITE_URL}/admin/worker">Workers</a></li>
        </ul>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
            <button type="submit" class="btn">Log out</button>
        </form>
   