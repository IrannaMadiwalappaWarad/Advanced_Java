<%@ page import="java.sql.*" %>

<html>
<head>
<title>Salary Report</title>
</head>
<body>

<%
Connection con = null;
PreparedStatement ps = null;
Statement st = null;
ResultSet rs = null;

int grandTotal = 0;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/Employee";
    String user = "root";
    String password = "-------------";

    con = DriverManager.getConnection(url, user, password);

    // Get form data
    String empno = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String salary = request.getParameter("salary");

    // Insert record
    if(empno != null && empname != null && salary != null){
        ps = con.prepareStatement("INSERT INTO Emp VALUES (?, ?, ?)");
        ps.setInt(1, Integer.parseInt(empno));
        ps.setString(2, empname);
        ps.setInt(3, Integer.parseInt(salary));
        ps.executeUpdate();
    }

    // Display report
    out.println("<h2>Salary Report</h2>");
    out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");

    st = con.createStatement();
    rs = st.executeQuery("SELECT * FROM Emp");

    while(rs.next()){
        int no = rs.getInt("Emp_NO");
        String name = rs.getString("Emp_Name");
        int sal = rs.getInt("Basicsalary");

        grandTotal += sal;

        out.println("Emp_No : " + no + "<br>");
        out.println("Emp_Name : " + name + "<br>");
        out.println("Basic : " + sal + "<br>");
        out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>");
    }

    out.println("<b>Grand Salary : " + grandTotal + "</b>");

} catch(Exception e){
    out.println(e);
}
%>

</body>
</html>
