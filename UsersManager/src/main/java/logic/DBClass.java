package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBClass {
	private String url;
    private String username;
    private String password;

    // Constructor
    public DBClass(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Get a database connection
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database: " + e.getMessage());
            return null;
        }
    }

}
