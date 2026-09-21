import java.sql.*;

public class display {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/crud",
                    "root",
                    "Anjalibs"
            );

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM emp1");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("eid") + " " +
                                rs.getString("name") + " " +
                                rs.getInt("salary")
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}