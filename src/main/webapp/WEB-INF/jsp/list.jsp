<%--
  Created by IntelliJ IDEA.
  User: FengLiQiang
  Date: 3/7/2019
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%--<%@ page isELIgnored ="false" %>--%>
<html>
<head>
    <title>展示</title>
</head>
<body>
    <table>
        <tr>
            <%--
                ${param.name} 等价于 request.getParamter("name")

                ${requestScope.name} 等价于 request.getAttribute("name")
            --%>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${requestScope.person.email}</td>
            <td>${requestScope.person.address.country}</td>
            <td>${requestScope.person.address.city}</td>
        </tr>
    </table>
</body>
</html>
