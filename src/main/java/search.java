import java.sql.*;

public class search {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/crud",
                    "root",
                    "Anjalibs"
            );

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM emp1 WHERE eid = ?"
            );

            ps.setInt(1, 2);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Employee ID: " + rs.getInt("eid"));
                System.out.println("eName: " + rs.getString("ename"));
                System.out.println("designation:"+rs.getString("designation"));
                System.out.println("Salary: " + rs.getInt("salary"));
            } else {
                System.out.println("Employee not found");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}