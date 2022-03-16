<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product list</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Product list</h1>


<c:if test="${empty productList}">
    <p>no product yet.</p>
    <a href="/auth/add-product">Add product</a>
</c:if>

<table>
    <c:forEach items="${productList}" var="product">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><a href="/product-details?id=${product.id}">Details</a></td>
            <td>
                <form action="/auth/removeProduct" method="post">
                    <input hidden name="productId" value="${product.id}">
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
