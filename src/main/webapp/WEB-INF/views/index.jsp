<%--
  Created by IntelliJ IDEA.
  User: Black Diamond
  Date: 8/4/2021
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Home</h3>
<form:form action="doLogin" method="post" modelAttribute="user">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="email">Account:</form:label></td>
                <td><form:input path="email"  /></td>
            </tr>
            <tr>
                <td><form:label path="password">Password:</form:label></td>
                <td><form:input type="password" path="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Login</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
<p style="color: red">${message}</p>
</body>
</html>
