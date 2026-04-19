<%
    String user = (String) session.getAttribute("username");
%>

<html>
<body>

<% if (user != null) { %>
    <h2>Hello again <%= user %></h2>
<% } else { %>
    <h2>Session Expired!</h2>
<% } %>

</body>
</html>
