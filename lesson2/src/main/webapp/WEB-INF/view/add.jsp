<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Add</title>
    </head>
    <body>
        <form action="add" method="POST" modelAttribute="product">
            <label for="id">Id</label>
            <input name="id" value="${product.id}">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" value="${product.title}">
            <label for="cost">Cost</label>
            <input type="text" name="cost" id="cost" value="${product.cost}">
            <input type="submit" value="Add new product">
        </form>
    </body>
</html>
