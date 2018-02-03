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
        <h1>Login Page</h1>
        <form action="${pageContext.request.contextPath}/login" method="post">       
	<c:if test="${param.error != null}">        
            <p style="color: red">
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">       
            <p style="color:blue;">
			You have been logged out.
		</p>
	</c:if>
                <h3>Enter Login Credentials</h3>
            <p>
		<label for="username">Username</label>
		<input type="text" id="username" name="user"/>	
	</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="pass"/>	
	</p>
        <p>
		<label for="remember_me">Remember Me</label>
                <input type="checkbox" id="remember_me" name="remember_me"/>	
	</p>
        <input type="hidden"                        
		name="${_csrf.parameterName}"
		value="${_csrf.token}"/>
	<button type="submit" class="btn">Log in</button>
</form>
        <p>OR</p>
        <a href="/OauthLogin/oauth2/authorization/google"">Google</a></br>
            <a href="/OauthLogin/oauth2/authorization/facebook">Facebook</a>
        
            <%@include file="shared/footer.jsp" %>