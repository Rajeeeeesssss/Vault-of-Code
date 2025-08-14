import java.sql.*;
import java.util.Scanner;

public class Example {
    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";       
    static final String PASS = "Rg@#1000";   
    static final String DB_NAME = "testdb";

    public static void main(String[] args) {
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
                System.out.println("Database ready.");
            }

            
            try (Connection conn = DriverManager.getConnection(URL + DB_NAME, USER, PASS)) {

                
                String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT, "
                        + "name VARCHAR(50), "
                        + "age INT)";
                conn.createStatement().executeUpdate(createTableSQL);
                System.out.println("Table ready.");

                
                Scanner sc = new Scanner(System.in);
                while (true) {
                    System.out.println("\n--- MENU ---");
                    System.out.println("1. Add Student");
                    System.out.println("2. View Students");
                    System.out.println("3. Update Student");
                    System.out.println("4. Delete Student");
                    System.out.println("5. Exit");
                    System.out.print("Enter choice: ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1: addStudent(conn, sc); break;
                        case 2: viewStudents(conn); break;
                        case 3: updateStudent(conn, sc); break;
                        case 4: deleteStudent(conn, sc); break;
                        case 5: System.out.println("Goodbye!"); return;
                        default: System.out.println("Invalid choice.");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ADD
    private static void addStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO students(name, age) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
            System.out.println("Student added.");
        }
    }

    // VIEW
    private static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("\nID\tName\tAge");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
            }
        }
    }

    // UPDATE
    private static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new name: ");
        String name = sc.next();
        System.out.print("Enter new age: ");
        int age = sc.nextInt();

        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Student updated.");
            else System.out.println("No student found with that ID.");
        }
    }

    // DELETE
    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Student deleted.");
            else System.out.println("No student found with that ID.");
        }
    }
}

