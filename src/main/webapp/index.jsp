<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <script src="${basePath}/jquery/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<br><br>

<button id="testAjaxDataPost">TestAjaxDataPost</button>

<br><br>


<%--<h3><a href="first/testParams?username=flq">testParams</a></h3>--%>

<%--<h1><a href="first/hello">Hello SprinMVC</a></h1>--%>

<%--<form action="first/method" method="post">--%>
    <%--<input type="submit" value="点击">--%>
<%--</form>--%>

<%--<h2><a href="first/fdsfdsfds/flqfdsfdsfdsf">test ant</a></h2>--%>

<%--<a href="first/pathVar/3">show PathVar</a>--%>

<%--<a href="first/testREST/1">testREST get</a>--%>

<%--<form action="first/testREST/1" method="post">--%>
    <%--<input type="hidden" name="_method" value="DELETE">--%>
    <%--<h1>test delete</h1>--%>
    <%--<input type="submit">--%>
<%--</form>--%>
<%--<form action="/first/testREST/1" method="post">--%>
    <%--<h1>test put</h1>--%>
    <%--<input type="hidden" name="_method" value="PUT">--%>
    <%--<input type="submit">--%>
<%--</form>--%>
<%--<form action="/first/testREST" method="post">--%>
    <%--<h1>test post</h1>--%>

    <%--<input type="submit">--%>
<%--</form>--%>

<h2><a href="first/testRequestParam">测试登录</a></h2>

<h1><a href="first/testHeader">测试请求头</a></h1>

<h1><a href="first/testCookieVaule">testCookieVaule</a></h1>

<form action="first/testPojo" method="post">
    id: <input type="text" name="id">
    name: <input type="text" name="name">
    email: <input type="email" name="email">
    country: <input type="text" name="address.country">
    city: <input type="text" name="address.city"><br>
    <input type="submit" value="submit">
</form>
<br><br>
<a href="first/testServlet">testServlet</a>
<a href="/first/testModelAndView">testModelAndView</a>

<br><br>
<a href="/first/testMap">testMap</a>

<br><br>
<h1><a href="/first/testRedirect">跳转</a></h1>

<form action="/first/testConverter" method="post">
    date:<input type="text " name="date">
    <input type="submit">
</form>

<form action="first/testRequestBody" method="post">
    id: <input type="text" name="id">
    name: <input type="text" name="name">
    email: <input type="email" name="email">
    country: <input type="text" name="address.country">
    city: <input type="text" name="address.city"><br>
    <input type="submit" value="submit">
</form>

<button id="testajax">Test ajax</button>

<h2 id="testAjaxPost" style="color:#FF0000;">TestAajxPost</h2>


<a href="/first/testException?num=2"> testException</a>
</body>
</html>
<script type="application/javascript">
    $(function () {



    // $("#testAjaxPost").click(function () {
    //     // $.get("/first/testAjax",'',function (data) {
    //     //     alert("json 数据获取成功");
    //     //     alert(data.id);
    //     //     alert(data.name);
    //     //     alert(data.email);
    //     //     alert(data.address.country);
    //     //     alert(data.address.city);
    //     // })
    //
    //     $.ajax({
    //         url:"first/testAjaxPost",
    //         type:"post",
    //         dataType:"json",
    //         data:{
    //             "id":22,
    //             "name":"testAjaxPost",
    //             "email":"testAjaxPost@qq.com",
    //             "country":"china",
    //             "city":"beijing"
    //         },
    //         error: function (XMLHttpResponse, textStatus, errorThrown) {
    //             alert("出错了！！");
    //             console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpResponse.readyState);
    //             console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpResponse.status);
    //             console.log("3 异步调用返回失败,textStatus:"+textStatus);
    //             console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
    //
    //         },
    //         success: function (data) {
    //             alert(data.msg);
    //         }
    //     });
    // })


        $("#testAjaxDataPost").click(function () {
            var postData = {
                "id":34,
                "name":"fengliqiang",
                "password":"199545"
            }
           $.ajax({
               async:false,
               cache:false,
               url:"first/testAjaxDataPost",
               type:"post",
               dataType:"json",
               contentType:"application/json",
               data:JSON.stringify(postData),
               success: function (data) {
                   alert(data.msg);
               },
               error: function () {
                   alert("出错了！！");
               }
           })
        });

    })
</script>
