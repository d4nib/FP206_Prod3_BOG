
package bog_dao;

import bog_models.Customer;


public class DAOCustomerFactory implements IDAOFactory<Customer, String>{

    @Override
    public IDAO<Customer, String> createDAO() {
        return new MySQLCustomerDAO();
    }
    
}
