<%--
  Created by IntelliJ IDEA.
  User: arthur
  Date: 26.05.19
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Custom Login Page</title>

    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>
    <h3>My Custom Login Page</h3>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
        method="post">

        <!-- Check for login error -->

        <c:if test="${param.error != null}">

            <i class="failed">Sorry! You entered invalid username/password</i>

        </c:if>

        <p>
            User name: <input type="text" name="username" />
        </p>

        <p>
            Password: <input type="password" name="password" />
        </p>

        <input type="submit" value="Login" />

    </form:form>
</body>
</html>
