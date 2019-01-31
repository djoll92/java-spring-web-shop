<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit customer</title>
    </head>
    <body>
        <h1>Edit customer</h1>
        <form:form action="edit_customer.htm?id=${customer.getId()}" method="post" commandName="customer">
            <form:label path="id">ID: ${customer.getId()}</form:label></br>
            <form:label path="name">Enter customer's name:</form:label></br>
            <form:input id="name" type="text" path="name" placeholder="${customer.getName()}"></form:input></br>
            <form:label path="email">Enter customer's email:</form:label></br>
            <form:input id="email" type="text" path="email" placeholder="${customer.getEmail()}"></form:input></br>
                <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>