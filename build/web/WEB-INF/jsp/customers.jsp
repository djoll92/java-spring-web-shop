<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
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
        <h2>Customers</h2>
        <ul>
            <li><a href="index.htm">Home</a></li>
            <li><a href="customers.htm">Customers</a></li>
            <li><a href="products.htm">Products</a></li>
            <li><a href="new_sale.htm">Sales</a></li>
        </ul>
        <table>
            <h3>All customers</h3>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>email</td>
                <td>total sum</td>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.getId()}</td>
                    <td>${customer.getName()}</td>
                    <td>${customer.getEmail()}</td>
                    <td>${customer.getTotal()}</td>
                    <td class="button"><button><a class="" href="edit_customer.htm?id=${customer.getId()}">edit</a></button></td>
                    <td class="button"><button><a href="customers.htm?id=${customer.getId()}">delete</button></td>
                </tr>
            </c:forEach>
        </table>
        <button style="margin-top: 5px;"><a href="new_customer.htm" style="text-decoration: none">add new customer</a></button>
    </body>
</html>
