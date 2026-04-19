<%@ page import="javax.servlet.http.Cookie" %>

<html>
<head>
    <title>Active Cookies</title>
</head>
<body>

<h2>Active Cookie List</h2>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <p>
                <b>Name:</b> <%= c.getName() %> |
                <b>Value:</b> <%= c.getValue() %> |
                <b>Max Age:</b> <%= c.getMaxAge() %>
            </p>
<%
        }
    } else {
%>
        <p>No Cookies Found</p>
<%
    }
%>

<br>
<a href="index.jsp">Add Another Cookie</a>

</body>
</html>
