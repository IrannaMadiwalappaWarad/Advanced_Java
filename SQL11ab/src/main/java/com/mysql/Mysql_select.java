package com.mysql;
import java.sql.*;
import java.util.Properties;

public class Mysql_select {
    public static void main(String[] args) {
        try {
            Connection dbConnection = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); // load driver

                String url = "jdbc:mysql://localhost:3306/test";
                Properties info = new Properties();
                info.put("user", "root");
                info.put("password", "---------------");

                dbConnection = DriverManager.getConnection(url, info);

                if (dbConnection != null) {
                    System.out.println("Successfully connected to MySQL database test");
                }

            } catch (Exception ex) {
                System.out.println("Error connecting to MySQL");
                ex.printStackTrace();
            }

            // SELECT
            String query = "SELECT * FROM coffee";
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String coffee_name = rs.getString("coffee_name");
                int price = rs.getInt("price");

                System.out.format("\n%d, %s, %d", id, coffee_name, price);
            }

            // INSERT
            PreparedStatement stmt = dbConnection.prepareStatement(
                "insert into coffee (coffee_name, price) values (?, ?)"
            );
            stmt.setString(1, "Tajmahal");
            stmt.setInt(2, 950);

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}