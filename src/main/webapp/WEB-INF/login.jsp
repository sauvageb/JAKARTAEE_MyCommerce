<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1>Login</h1>
<form action="login" method="post">
    <label for="usernameInput"></label>
    <input id="usernameInput" type="text" name="username">
    <button type="submit">Login</button>
</form>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
