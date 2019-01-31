<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
        <style>
            a {
                text-decoration: none;
            }

            a:visited {
                color: black;
            }

            td {
                padding: 5px;
            }
            table {
                border-collapse: collapse;
            }
            td {
                border: 1px solid black;
            }
            td.button {
                border: 0px;
            }
        </style>
    </head>
    <body>
        <h2>Sale</h2>
        <ul>
            <li><a href="index.htm">Home</a></li>
            <li><a href="customers.htm">Customers</a></li>
            <li><a href="products.htm">Products</a></li>
            <li><a href="new_sale.htm">Sales</a></li>
        </ul>
        <h3>New sale</h3>
        <form:form action="new_sale.htm" method="POST" commandName="sale">
            <form:label path="customerId">Select customer: </form:label>
            <form:select id="customer" path="customerId">
                <c:forEach var="customer" items="${customers}">
                    <form:option value="${customer.getId()}">${customer}</form:option>
                </c:forEach>
            </form:select></br></br>
            <form:label path="productId">Select product: </form:label>
            <form:select id="product" path="productId">
                <c:forEach var="product" items="${products}">
                    <form:option value="${product.getId()}">${product}</form:option>
                </c:forEach>
            </form:select></br></br>
            <form:label path="quantity">Choose quantity: </form:label>
            <form:input type="number" path="quantity" min="0"></form:input></br></br>
            <input type="submit" value="Submit">
        </form:form>
            <p style="color: red">${message}</p>
    </body>   
</html>
