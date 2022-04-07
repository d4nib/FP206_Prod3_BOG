
package bog_dao;


public interface IDAOFactory<T, K> {
    
    public abstract IDAO<T,K> createDAO();
}
