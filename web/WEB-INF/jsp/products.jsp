<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
        <style>
            a {
                text-decoration: none;
                color: black;
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
        <h2>Products</h2>
        <ul>
            <li><a href="index.htm">Home</a></li>
            <li><a href="customers.htm">Customers</a></li>
            <li><a href="products.htm">Products</a></li>
            <li><a href="new_sale.htm">Sales</a></li>
        </ul>
        <table t>
            <h3>All products</h3>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>price per unit</td>
                <td>quantity</td>                
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.getId()}</td>
                    <td>${product.getName()}</td>
                    <td>${product.getPrice()}</td>
                    <td>${product.getQuantity()}</td>
                    <td class="button"><button><a href="edit_product.htm?id=${product.getId()}">edit</a></button></td>
                    <td class="button"><button><a href="products.htm?id=${product.getId()}">delete</button></td>
                </tr>
            </c:forEach>
        </table>
        <button style="margin-top: 5px;"><a href="new_product.htm" style="text-decoration: none">add new product</a></button>
    </body>
</html>
