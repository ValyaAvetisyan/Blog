<%@ page import="javafx.geometry.Pos" %>
<%@ page import="model.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Category" %>
<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Home</title>
    <%--<link href="${pageContext.request.contextPath}style.css" rel="stylesheet" type="text/css" >--%>
    <link href="/css/style.css" rel="stylesheet" type="text/css" media="screen" />

</head>
<body>
<div id="wrapper">
    <div id="header-wrapper">
        <div id="header">
            <div id="logo">
                <h1><a href="#">Timeless </a></h1>
                <p>template design by <a href="http://www.freecsstemplates.org/">CSS Templates</a></p>
            </div>
        </div>
    </div>
    <!-- end #header -->
    <div id="menu">
        <ul>
            <li class="current_page_item"><a href="#">Home</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Photos</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Links</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </div>
    <!-- end #menu -->
    <div id="page">
        <div id="page-bgtop">
            <div id="page-bgbtm">
                <div id="content">
                    <% List<Post> posts = (List<Post>) request.getAttribute("posts"); %>
                    <% List<Category> categories = (List<Category>) request.getAttribute("categories"); %>
                    <% User user = (User) session.getAttribute("user"); %>


                    <%--for(post.length) --%>
                    <div class="post">
                        <%   for (Post post : posts) {%>
                        <h2 class="title"><a href="#"><%=post.getTitle()%>
                        </a></h2>
                        <p class="meta">Posted by <%=post.getUserId()%><%=post.getTimestamp()%>
                            &nbsp;&bull;&nbsp;</p>
                        <div class="entry">
                            <%if (post.getPicUrl() != null && !post.getPicUrl().equals("")){%>
                            <img src="/getResource?fileName=<%=post.getPicUrl()%>" width="200">
                            <%--<p><img src="<%=post.getPicUrl()%>" width="186" height="186" alt=""--%>
                                    <%--class="alignleft border"/>--%>
                                <%=post.getText()%>
                            </p>
                        </div>
                        <% }%>
                        <% }%>
                    </div>

                    <%----%>
                    <div style="clear: both;">&nbsp;</div>
                </div>
                <!-- end #content -->
                <%--<div id="sidebar">--%>
                <%--<ul>--%>
                <%--<li>--%>
                <%--<h2>Aliquam tempus</h2>--%>
                <%--<p>Mauris vitae nisl nec metus placerat perdiet est. Phasellus dapibus semper consectetuer--%>
                <%--hendrerit.</p>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<h2>Categories</h2>--%>
                <%--<ul>--%>
                <%--<% for (Category category : categories) {%>--%>

                <%--<li><a href="#"><%=category.getName()%>--%>
                <%--</a></li>--%>

                <%--</ul>--%>
                <%--<%}%>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<h2>Blogroll</h2>--%>
                <%--<ul>--%>
                <%--<li><a href="#">Aliquam libero</a></li>--%>
                <%--<li><a href="#">Consectetuer adipiscing elit</a></li>--%>
                <%--<li><a href="#">Metus aliquam pellentesque</a></li>--%>
                <%--<li><a href="#">Suspendisse iaculis mauris</a></li>--%>
                <%--<li><a href="#">Urnanet non molestie semper</a></li>--%>
                <%--<li><a href="#">Proin gravida orci porttitor</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
                <%--<li>--%>
                <%--<h2>Archives</h2>--%>
                <%--<ul>--%>
                <%--<li><a href="#">Aliquam libero</a></li>--%>
                <%--<li><a href="#">Consectetuer adipiscing elit</a></li>--%>
                <%--<li><a href="#">Metus aliquam pellentesque</a></li>--%>
                <%--<li><a href="#">Suspendisse iaculis mauris</a></li>--%>
                <%--<li><a href="#">Urnanet non molestie semper</a></li>--%>
                <%--<li><a href="#">Proin gravida orci porttitor</a></li>--%>
                <%--</ul>--%>
                <%--</li>--%>
                <%--</ul>--%>
                <%--</div>--%>
                <!-- end #sidebar -->
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
    </div>
    <!-- end #page -->
</div>
<div id="footer">
    <p>Copyright (c) 2011 Sitename.com. All rights reserved. Design by <a href="http://www.freecsstemplates.org/"> CSS
        Templates</a>.</p>
</div>
<!-- end #footer -->
<div align=center>This template downloaded form <a href='http://all-free-download.com/free-website-templates/'>free
    website templates</a></div>
</body>

</html>
