package eli.swimming_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/eli's pool";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return this. connection;
    }
}
