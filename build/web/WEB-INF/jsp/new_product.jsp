<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New product</title>
    </head>
    <body>
        <h1>New product</h1>
        <form:form action="new_product.htm" method="post" commandName="product">
            <form:label path="name">Enter product name:</form:label></br>
            <form:input id="name" type="text" path="name" placeholder="product name..."></form:input></br>
            <form:label path="price">Enter product price:</form:label></br>
            <form:input id="price" type="text" path="price" placeholder="product price..."></form:input></br>
            <form:label path="quantity">Enter product quantity:</form:label></br>
            <form:input id="quantity" type="text" path="quantity" placeholder="product's quantity..."></form:input></br>
                <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>