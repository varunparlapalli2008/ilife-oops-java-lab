import java.sql.*;
public class JdbcInsertDemo {
    public static void main(String[] args) {
        String url="jdbc:sqlite:college.db";
        try (Connection c=DriverManager.getConnection(url); Statement s=c.createStatement()) {
            s.executeUpdate("CREATE TABLE IF NOT EXISTS students(id INTEGER PRIMARY KEY, name TEXT NOT NULL)");
            try (PreparedStatement p=c.prepareStatement("INSERT INTO students(name) VALUES(?)")) { p.setString(1,"Varun"); System.out.println("Rows inserted: "+p.executeUpdate()); }
        } catch(SQLException e) { System.err.println(e.getMessage()); }
    }
}
