import java.sql.*;
public class JdbcConnectionDemo {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:college.db")) {
            System.out.println("Database connected successfully: " + !connection.isClosed());
        } catch (SQLException e) { System.err.println("Connection failed: " + e.getMessage()); }
    }
}
