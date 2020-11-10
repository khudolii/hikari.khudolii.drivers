<%--
  Created by IntelliJ IDEA.
  User: Yevhenii Khudolii
  Date: 10.11.2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="driverBean" scope="request" type="logic.beans.DriverBean"/>
    <c:forEach items="${driverBean.drivers}" var="d">
        <tr>
            <td><c:out value="${d.driverId}" /></td>
            <td>${d.firstName}</td>
            <td>${d.lastName}</td>
            <td>${d.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
