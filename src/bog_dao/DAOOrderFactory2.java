package bog_dao;

import java.sql.Connection;
import bog_models.Order;

public class DAOOrderFactory implements IDAOFactory<Order, String>{

    @Override
    public IDAO<Order, String> createDAO(Connection conn) {
        return new MySQLOrderDAO();
    }
    
}
