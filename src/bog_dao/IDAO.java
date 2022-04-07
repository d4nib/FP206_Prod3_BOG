/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bog_dao;

import java.util.ArrayList;


public interface IDAO<T,K>{
    
    public void create(T insertado) throws DAOException;
    
    public T readOne(K id) throws DAOException;
    
    public ArrayList<T> readAll() throws DAOException;
    
    public void update(T modificado) throws DAOException;
    
    public void delete(T eliminado) throws DAOException;
    
    
}
