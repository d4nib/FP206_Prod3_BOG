/* customers
+------------------+---------------------------+------+-----+---------+-------+
| Field            | Type                      | Null | Key | Default | Extra |
+------------------+---------------------------+------+-----+---------+-------+
| email            | varchar(50)               | NO   | PRI | NULL    |       |
| firstname        | varchar(45)               | YES  |     | NULL    |       |
| lastname         | varchar(45)               | YES  |     | NULL    |       |
| address          | varchar(200)              | YES  |     | NULL    |       |
| idCardNumber     | varchar(20)               | YES  |     | NULL    |       |
| customerFee      | double                    | YES  |     | NULL    |       |
| customerDiscount | int(11)                   | YES  |     | NULL    |       |
| type             | enum('PREMIUM','REGULAR') | YES  |     | NULL    |       |
+------------------+---------------------------+------+-----+---------+-------+
*/


package bog_dao;

import java.util.ArrayList;
import bog_models.Customer;

public class MySQLCustomerDAO implements CustomerDAO{

    @Override
    public void create(Customer insertado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Customer readOne(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Customer> readAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(Customer modificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Customer eliminado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
