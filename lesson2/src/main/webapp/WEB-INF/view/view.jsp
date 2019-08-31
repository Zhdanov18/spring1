<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>View</title>
    </head>
    <body>
        <p>${product.id}</p>
        <p>${product.title}</p>
        <p>${product.cost}</p>
        <a href="${pageContext.request.contextPath}">Return to main page</a>
    </body>
</html>
