import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) {
        String serverUrl = "jdbc:mysql://127.0.0.1:3306/";
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/testdb";
        String username = "root";
        String password = "Ayush@12345";

        try {

            System.out.println("🔄 Connecting to MySQL server...");
            Connection serverConn = DriverManager.getConnection(serverUrl, username, password);
            System.out.println("✅ Connected to MySQL server successfully!");

            Statement stmt = serverConn.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS testdb");
            System.out.println("✅ Database 'testdb' created or already exists!");

            serverConn.close();

            System.out.println("🔄 Connecting to testdb database...");
            Connection dbConn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("✅ Successfully connected to testdb database!");

            dbConn.close();
            System.out.println("🎉 All connections successful!");

        } catch (SQLException e) {
            System.out.println("❌ Connection failed!");
            System.out.println("Error details: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
