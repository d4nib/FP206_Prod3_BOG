/* orders
+------------------+-------------+------+-----+---------+----------------+
| Field            | Type        | Null | Key | Default | Extra          |
+------------------+-------------+------+-----+---------+----------------+
| orderID          | int(11)     | NO   | PRI | NULL    | auto_increment |
| productID        | varchar(5)  | YES  | MUL | NULL    |                |
| customerEmail    | varchar(50) | YES  | MUL | NULL    |                |
| productQuantity  | int(11)     | YES  |     | NULL    |                |
| subtotal         | double      | YES  |     | NULL    |                |
| creationDateTIme | datetime    | YES  |     | NULL    |                |
| hadnlingTime     | int(11)     | YES  |     | NULL    |                |
| isSent           | tinyint(4)  | YES  |     | 0       |                |
+------------------+-------------+------+-----+---------+----------------+
*/ 


package bog_dao;

import java.util.ArrayList;

import bog_models.Order;

public class MySQLOrderDAO implements OrderDAO {

    @Override
    public void create(Order insertado) throws DAOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Order readOne(String id) throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Order> readAll() throws DAOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Order modificado) throws DAOException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Order eliminado) throws DAOException {
        // TODO Auto-generated method stub
        
    }
    
}
