<%@ page import="model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>
<%List<User> users = (List<User>)request.getAttribute("users") ;%>

<a href="/logout">Logout</a>
<br>
Add Category:
<form action="/addCategory" method="post">
    Name: <input type="text" name="name"> <br>
    <input type="submit" value="OK">
</form>

<br>
<br>
<br>

Add Post:
<form action="/addPost" method="post" enctype="multipart/form-data">

    title: <input type="text" name="title"><br>
    text: <textarea name="text"></textarea><br>
    category:  <select name="categoryId">
    <% for (Category category : categories) {%>
    <option value="<%=category.getId()%>"><%=category.getName()%>
    </option>
    <%}%>
</select><br>
    <%--<select name="userId">--%>
    <%--<%for (User user : users) {%>--%>
    <%--<option value="<%=user.getId()%>"><%=user.getName()%>--%>
    <%--</option>--%>
       <%--<%}%>--%>
    <%--</select> <br>--%>
    <input type="file" name="picture" ><br>
    <input type="submit" name="OK">

</form>

</body>
</html>
