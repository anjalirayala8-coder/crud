import java.sql.Connection;
import java.sql.DriverManager;

public class demo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/crud",
                    "root",
                    "Anjalibs"
            );

            System.out.println("Success");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
