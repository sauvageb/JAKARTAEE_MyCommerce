<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Details</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<c:if test="${ERROR_TYPE_ID_PRODUCT}">
    <p>product id must be an integer</p>
</c:if>

<c:if test="${ERROR_UNKNOWN_PRODUCT}">
    <p>Product does not exist</p>
</c:if>

<c:if test="${not empty product}">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Content</th>
            <th>Price</th>
            <th>Details</th>
        </tr>
        </thead>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.content}</td>
            <td>${product.price}</td>
        </tr>
    </table>
</c:if>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
