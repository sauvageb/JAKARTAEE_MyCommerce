<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>

<body class="d-flex flex-column h-100">
<jsp:include page="header.jsp"></jsp:include>

<main class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Add category</h1>

        <form action="/auth/add-category" method="post">
            <label for="name">Name</label>
            <input id="name" type="text" name="cName">
            <button type="submit">Add</button>
        </form>

    </div>
</main>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
