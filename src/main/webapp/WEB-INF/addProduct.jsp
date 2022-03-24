<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body class="d-flex flex-column h-100">
<jsp:include page="header.jsp"></jsp:include>

<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Add product</h1>

        <form action="/auth/add-product" method="post">
            <label for="name">Name</label>
            <input id="name" type="text" name="pName">
            <label for="content">Content</label>
            <input id="content" type="text" name="pContent">
            <label for="price">Price</label>
            <input id="price" type="number" name="pPrice">
            <button type="submit">Add</button>
        </form>

    </div>
</main>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
