package bog_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoManager {
    private Connection conn;

    public MySQLDaoManager() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/P5_Prod3_BOG", "bog", "bog");
    }

}
