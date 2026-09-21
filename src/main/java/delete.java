import java.sql.*;

public class delete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/crud",
                    "root",
                    "Anjalibs"
            );

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM emp1 WHERE eid = ?"
            );

            ps.setInt(1, 6);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data deleted successfully");
            } else {
                System.out.println("Employee not found");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}