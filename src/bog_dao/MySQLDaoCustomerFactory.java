package bog_dao;

import java.sql.Connection;

public class MySQLDaoCustomerFactory implements DAOCustomerFactory {

    @Override
    public CustomerDAO createDAO(Connection con) {
        
        return new MySQLCustomerDAO(con);
    }
    
}
