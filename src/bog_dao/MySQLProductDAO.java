/* products
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| productID   | varchar(5)   | NO   | PRI | NULL    |       |
| productName | varchar(45)  | YES  |     | NULL    |       |
| description | varchar(500) | YES  |     | NULL    |       |
| price       | double       | YES  |     | NULL    |       |
| shippingFee | double       | YES  |     | NULL    |       |
| hadlingTime | int(11)      | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
 */
package bog_dao;
import bog_models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySQLProductDAO implements ProductDAO{
    //Los ? son para luego el PreparedStatement
    final String INSERT = "INSERT INTO Producto( productName, description, price, shippingFee) VALUES( ?, ?, ?, ?)";
    final String UPDATE = "UPDATE Producto SET nombre = ?, apellidos = ?, fecha_nac = ? WHERE id_alumno = ?";
    final String DELETE = "DELETE FROM Producto WHERE id_alumno = ?";
    final String GETALL = "SELECT id_alumno, nombre, apellidos, decha_nac FROM alumnos";
    final String GETONE = "SELECT id_alumno, nombre, apellidos, decha_nac WHERE id_alumnos = ?";
    
    private Connection connection;
    
    public MySQLProductDAO(Connection conn) {
        this.connection = conn; 
    }
    
    @Override
    public void create(Product p) throws DAOException{
        PreparedStatement stat = null;
        ResultSet rs = null;

        try {
            stat = connection.prepareStatement(INSERT); 
            //stat.setString(1, i.getProductID()); //Utilizamos los metodos set para convertir de los datos java a sql. El indice representa la posicion de los interrogantes
            //Hay que poner todos los atributos del Product en el indice que toque de la tabla
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("No se ha guardado");
            }

            rs = stat.getGeneratedKeys();
            if(rs.next()){
                p.setproductID(rs.getString(1));
            }else{
                throw new DAOException("No se ha podido asignar ID al alumno.");
            }
        } 
        catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        }
        finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);                
                }
            }
            if(stat != null){
                try{
                    stat.close();
                } catch(SQLException e){
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
    }
    
  @Override
    public Product readOne(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Product> readAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Product modificado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Product eliminado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Product convertir(ResultSet rs){
        return null;
        //https://www.youtube.com/watch?v=q8EdOcTcRsM&ab_channel=makigas%3Atutorialesdeprogramaci%C3%B3n
    }
    
}
