<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: FengLiQiang
  Date: 3/6/2019
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>success page</h1>

    <h1>${names}</h1>

    <h2>${sessionScope.personse}</h2>

    <fmt:message key="i18n.username"></fmt:message>
    <fmt:message key="i18n.password"></fmt:message>
</body>
</html>
