package bog_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoManager {
    private Connection con;

    public MySQLDaoManager(String host, String username, String password, String database) throws SQLException {
        this.con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
    }

}
