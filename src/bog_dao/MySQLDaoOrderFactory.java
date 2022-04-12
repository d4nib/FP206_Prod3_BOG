package bog_dao;

import java.sql.Connection;

public class MySQLDaoOrderFactory implements DAOOrderFactory{

    @Override
    public OrderDAO createDAO(Connection con) {
        
        return new MySQLOrderDAO(con);
    }
    
}
