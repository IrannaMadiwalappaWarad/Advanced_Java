<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("cdomain");
    int age = Integer.parseInt(request.getParameter("cage"));

    Cookie cookie = new Cookie(name, domain);
    cookie.setMaxAge(age);
    response.addCookie(cookie);
%>

<html>
<body>
<h2>Cookie Added!</h2>
<a href="showCookies.jsp">Go to Active Cookie List</a>
</body>
</html>
