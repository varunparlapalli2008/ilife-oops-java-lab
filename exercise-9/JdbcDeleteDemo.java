import java.sql.*;
public class JdbcDeleteDemo {
    public static void main(String[] args) {
        try (Connection c=DriverManager.getConnection("jdbc:sqlite:college.db"); PreparedStatement p=c.prepareStatement("DELETE FROM students WHERE name=?")) {
            p.setString(1,"Varun"); System.out.println("Rows deleted: "+p.executeUpdate());
        } catch(SQLException e) { System.err.println(e.getMessage()); }
    }
}
