<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Web Shop</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
    </head>

    <body>
        <h2>Home page</h2>
        <ul>
            <li><a href="index.htm">Home</a></li>
            <li><a href="customers.htm">Customers</a></li>
            <li><a href="products.htm">Products</a></li>
            <li><a href="new_sale.htm">Sales</a></li>
        </ul>
    </body>
</html>
