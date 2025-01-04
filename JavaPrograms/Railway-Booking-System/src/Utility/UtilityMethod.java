package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilityMethod {
    public static Connection createConnection(String url , String username , String password) throws SQLException {
        Connection conn = DriverManager.getConnection(url , username , password);
        System.out.println("DB connected");
        return conn;
    }
}
