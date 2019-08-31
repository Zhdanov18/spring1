<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Products</title>
    </head>
   <body>
        <h2>Products</h2>
        <table>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td><a href="view/${product.id}">${product.title}</a></td>
                    <td>${product.cost}</td>
                </tr>
            </c:forEach>
        </table>
        <c:url value="/add" var="add"/>
        <a href="${add}">Add new product</a>
    </body>
</html>
