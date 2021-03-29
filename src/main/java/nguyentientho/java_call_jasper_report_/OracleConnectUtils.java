package nguyentientho.java_call_jasper_report_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnectUtils {
    public static Connection getOracleConnection() throws SQLException {
        String hostName = "10.26.53.30";
        String sid = "TKTHU";
        String userName = "HOSTTKT";
        String password = "HOSTIT";

        return getOracleConnection(hostName, sid, userName, password);
    }

    public static Connection getOracleConnection(String hostName, String sid, String userName, String password) throws SQLException {
        // Cấu trúc URL kết nối của Oracle DB
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
