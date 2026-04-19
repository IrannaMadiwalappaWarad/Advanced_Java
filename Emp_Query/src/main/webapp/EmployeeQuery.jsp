<%@ page import="java.sql.*" %>

<html>
<head>
<title>Salary Report</title>
</head>
<body>

<%
Connection dbConnection = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/Employee";
    String user = "root";
    String password = "-----------";

    dbConnection = DriverManager.getConnection(url, user, password);

    if (dbConnection != null) {
        out.println("Successfully connected to MySQL database Employee<br>");
    }

    String ch = request.getParameter("ch");

    // SQL QUERY with LIKE
    String query = "SELECT * FROM Emp WHERE Emp_Name LIKE '" + ch + "%'";

    Statement st = dbConnection.createStatement();
    ResultSet rs = st.executeQuery(query);

    out.println("<h2>Salary Report</h2>");
    out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

    while (rs.next()) {
        int id = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int salary = rs.getInt("Basicsalary");

        out.println("Emp_No : " + id + "<br>");
        out.println("Emp_Name : " + name + "<br>");
        out.println("Basic : " + salary + "<br>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
    }

    rs.close();
    dbConnection.close();

} catch (Exception e) {
    out.println("Error: " + e.getMessage());
}
%>

</body>
</html>

