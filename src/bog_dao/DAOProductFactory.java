
package bog_dao;

import bog_models.Product;


public class DAOProductFactory implements IDAOFactory<Product,String>{

    @Override
    public IDAO<Product,String> createDAO() {
        return null;
        //return  new SQLProductDAO();
    }
}
