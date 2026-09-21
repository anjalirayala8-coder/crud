import java.sql.*;
import java.util.Scanner;

public class fsd {

    static final String URL = "jdbc:mysql://127.0.0.1:3306/crud";
    static final String USER = "root";
    static final String PASSWORD = "Anjalibs";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            while (true) {

                System.out.println("\n===== CRUD OPERATIONS =====");
                System.out.println("1. Insert");
                System.out.println("2. Display");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Search");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // CREATE
                        System.out.print("Enter Employee ID: ");
                        int eid = sc.nextInt();

                        System.out.print("Enter Employee Name: ");
                        String ename = sc.next();
                        System.out.println("Enter employee designation: ");
                        String designation = sc.next();
                        System.out.print("Enter Salary: ");
                        int salary = sc.nextInt();

                        String insertSQL =
                                "INSERT INTO emp1(eid, ename,designation, salary) VALUES (?, ?, ?,?)";

                        PreparedStatement insertPS =
                                con.prepareStatement(insertSQL);

                        insertPS.setInt(1, eid);
                        insertPS.setString(2, ename);
                        insertPS.setString(3,designation);
                        insertPS.setInt(4, salary);

                        int inserted = insertPS.executeUpdate();

                        if (inserted > 0) {
                            System.out.println("Data inserted successfully");
                        }

                        insertPS.close();
                        break;


                    case 2:
                        // READ
                        String selectSQL = "SELECT * FROM emp1";

                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(selectSQL);

                        System.out.println("\nID\tName\tdesignation\tSalary");
                        System.out.println("-------------------------");

                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("eid") + "\t" +
                                            rs.getString("ename") + "\t" +
                                            rs.getString("designation")+ "\t" +
                                            rs.getInt("salary")
                            );
                        }

                        rs.close();
                        st.close();
                        break;


                    case 3:
                        // UPDATE
                        System.out.print("Enter Employee ID to update: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter new salary: ");
                        int newSalary = sc.nextInt();

                        String updateSQL =
                                "UPDATE emp1 SET salary = ? WHERE eid = ?";

                        PreparedStatement updatePS =
                                con.prepareStatement(updateSQL);

                        updatePS.setInt(1, newSalary);
                        updatePS.setInt(2, updateId);

                        int updated = updatePS.executeUpdate();

                        if (updated > 0) {
                            System.out.println("Data updated successfully");
                        } else {
                            System.out.println("Employee not found");
                        }

                        updatePS.close();
                        break;


                    case 4:
                        // DELETE
                        System.out.print("Enter Employee ID to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteSQL =
                                "DELETE FROM emp1 WHERE eid = ?";

                        PreparedStatement deletePS =
                                con.prepareStatement(deleteSQL);

                        deletePS.setInt(1, deleteId);

                        int deleted = deletePS.executeUpdate();

                        if (deleted > 0) {
                            System.out.println("Data deleted successfully");
                        } else {
                            System.out.println("Employee not found");
                        }

                        deletePS.close();
                        break;


                    case 5:
                        // SEARCH
                        System.out.print("Enter Employee ID to search: ");
                        int searchId = sc.nextInt();

                        String searchSQL =
                                "SELECT * FROM emp1 WHERE eid = ?";

                        PreparedStatement searchPS =
                                con.prepareStatement(searchSQL);

                        searchPS.setInt(1, searchId);

                        ResultSet searchRS =
                                searchPS.executeQuery();

                        if (searchRS.next()) {

                            System.out.println("\nEmployee Found");
                            System.out.println("ID: " +
                                    searchRS.getInt("eid"));

                            System.out.println("Name: " +
                                    searchRS.getString("ename"));

                            System.out.println("Salary: " +
                                    searchRS.getInt("salary"));

                        } else {
                            System.out.println("Employee not found");
                        }

                        searchRS.close();
                        searchPS.close();
                        break;


                    case 6:
                        System.out.println("Program ended.");
                        con.close();
                        sc.close();
                        return;


                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}