<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Add category</h1>
<form action="/auth/add-category" method="post">
    <label for="name">Name</label>
    <input id="name" type="text" name="cName">
    <button type="submit">Add</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
