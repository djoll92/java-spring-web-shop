<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit product</title>
    </head>
    <body>
        <h1>Edit product</h1>
        <form:form action="edit_product.htm?id=${product.getId()}" method="post" commandName="product">
            <form:label path="id">ID: ${product.getId()}</form:label></br>
            <form:label path="name">Enter product name:</form:label></br>
            <form:input id="name" type="text" path="name" placeholder="${product.getName()}"></form:input></br>
            <form:label path="price">Enter product price:</form:label></br>
            <form:input id="price" type="text" path="price" placeholder="${product.getPrice()}"></form:input></br>
            <form:label path="quantity">Enter product's quantity:</form:label></br>
            <form:input id="quantity" type="text" path="quantity" placeholder="${product.getQuantity()}"></form:input></br>
                <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>