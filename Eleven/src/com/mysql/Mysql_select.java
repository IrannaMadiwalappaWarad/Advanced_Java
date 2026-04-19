//11a. Q1. Read all the existing records from the table coffee which is from the database test and insert a new coffee product into it 
package com.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;

public class Mysql_select {
    public static void main(String[] args) {

        Connection dbConnection = null;

        try {
            // Step 1: Connect to database
            String url = "jdbc:mysql://localhost:3306/Eleven";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "I@m2w312@nannu");

            dbConnection = DriverManager.getConnection(url, info);

            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database test");
            }

            // Step 2: SELECT query
            String query = "SELECT * FROM coffee";
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Step 3: Display records
            while (rs.next()) {
                int id = rs.getInt("id");
                String coffee_name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.println(id + " | " + coffee_name + " | " + price);
            }

            // Step 4: INSERT using PreparedStatement
            String insertQuery = "INSERT INTO coffee (coffee_name, price) VALUES (?, ?)";
            PreparedStatement pstmt = dbConnection.prepareStatement(insertQuery);

            pstmt.setString(1, "Tajmahal");
            pstmt.setInt(2, 950);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("New coffee product inserted successfully!");
            }

            // Close resources
            pstmt.close();
            rs.close();
            st.close();
            dbConnection.close();

        } catch (SQLException e) {
            System.out.println("Database error occurred");
            e.printStackTrace();
        }
    }
}
