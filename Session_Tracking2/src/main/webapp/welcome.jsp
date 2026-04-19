<%@ page import="java.util.*" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    // Get name from form
    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("username", name);
    }

    // Set session expiry time (1 minute)
    session.setMaxInactiveInterval(60);

    String user = (String) session.getAttribute("username");
%>

<% if (user != null) { %>
    <h2>Hello <%= user %>!</h2>
    <p>Session will expire in 1 minute.</p>

    <a href="check.jsp">Click here to check session</a>
<% } else { %>
    <h2>Session Expired! Please enter your name again.</h2>
    <a href="index.jsp">Go Back</a>
<% } %>

</body>
</html>
