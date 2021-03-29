package nguyentientho.java_call_jasper_report_;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getConnection() throws SQLException {
        return OracleConnectUtils.getOracleConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Loading connection oracle ...");
        Connection conn = ConnectionUtils.getConnection();
        System.out.println("Get connection " + conn);
        System.out.println("Done Connected !!!");
    }

}
