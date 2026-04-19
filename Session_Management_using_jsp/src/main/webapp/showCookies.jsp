<%
    Cookie[] cookies = request.getCookies();
%>

<html>
<body>
<h2>Active Cookies</h2>

<%
    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            Name: <%= c.getName() %> <br>
            Value: <%= c.getValue() %> <br><br>
<%
        }
    }
%>

</body>
</html>
