package main.java;

import java.sql.*;

public class insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/crud",
                    "root",
                    "Anjalibs"
            );

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO emp1(eid, ename,designation, salary) VALUES (?, ?, ?,?)"
            );

            ps.setInt(1, 5);
            ps.setString(2, "Arjun");
            ps.setString(3, "Data Analyst");
            ps.setInt(4,45000);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data inserted successfully");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}