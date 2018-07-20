
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
Login:

<form action="/login" method="post">
    email: <input type="email" name="email"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="LOGIN">
</form>
<br>
<br>
<br>
Register:
<form action="/register" method="post">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="email" name="email"><br>
    password: <input type="password" name="password"><br>
    type: <input type="text" name="type"><br>
    <input type="submit" value="REGISTER">
</form>
</body>
</html>
