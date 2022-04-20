/* orders
+------------------+--------------+------+-----+---------+----------------+
| Field            | Type         | Null | Key | Default | Extra          |
+------------------+--------------+------+-----+---------+----------------+
| orderID          | int(11)      | NO   | PRI | NULL    | auto_increment |
| productID        | varchar(5)   | YES  | MUL | NULL    |                |
| customerEmail    | varchar(50)  | YES  | MUL | NULL    |                |
| productQuantity  | int(11)      | YES  |     | NULL    |                |
| subtotal         | decimal(5,2) | YES  |     | NULL    |                |
| creationDateTIme | varchar(50)  | YES  |     | NULL    |                |
| handlingTime     | int(11)      | YES  |     | NULL    |                |
+------------------+--------------+------+-----+---------+----------------+
*/ 


package bog_dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;


import bog_models.Order;




public class MySQLOrderDAO implements OrderDAO {
    
    final String INSERT = "INSERT INTO orders (productID , customerEmail, productQuantity, subtotal, creationDateTIme, hadnlingTime ) VALUES (?, ?, ?, ?, ?, ?);";
    final String UPDATE = "UPDATE orders SET orderID = ?, productID = ?, customerEmail = ?, productQuantity = ?, subtotal = ?, creationDateTime = ?, handlingTime = ?, isSent = ?";
    final String DELETE = "DELETE FROM orders WHERE orderID = ?";
    final String GETALL = "SELECT * FROM orders";
    final String GETONE = "SELECT orderID, productID, customerEmail, productQuantity, subtotal, creationDateTime, handlingTime, isSent FROM orders WHERE orderID = ?";


    private Connection conn;
    
    public MySQLOrderDAO(Connection conn){
        this.conn=conn;}

    
    @Override
    public void create(Order insertado) throws DAOException {
    PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            // stat.setInt(1, 0);
            stat.setString(1, insertado.getProductID());
            stat.setString(2, insertado.getCustomerEmail());
            stat.setInt(3, insertado.getproductQuantity());
            stat.setDouble(4, insertado.getSubtotal());
            stat.setString(5, LocalDateTime.now().toString());
            stat.setInt(6, insertado.gethandlingTime());
            // stat.setBoolean(8,insertado.isCancellable());
            if (stat.executeUpdate() ==0){
                throw new DAOException("Puede que el pedido no se haya guardado");
        }
        } catch (SQLException ex) {
            throw new DAOException("Error de creación", ex);
        } finally {
            if (stat != null){
                try {
                    stat.close();
                }catch (SQLException ex){
                    throw new DAOException ("No se ha podido cerrar la conexión", ex);
                }
            }
        }        
    }
    
        private Order convertir(ResultSet rs) throws SQLException{
            int orderID = rs.getInt("orderID");
            String productID = rs.getString("productID");
            String customerEmail = rs.getString("customerEmail");
            int productQuantity = rs.getInt("productQuantity");
            Double subtotal = rs.getDouble("subtotal");
            String creationDateTime = rs.getNString("creationDateTime");
            int handlingTime = rs.getInt("handlingTime");
            //Boolean isSent=rs.getBoolean("isSent");

            Order order = new Order (orderID, productID, customerEmail, productQuantity, subtotal, creationDateTime, handlingTime);
            return order; 
        }

    @Override
    public Order readOne(String id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Order order = null;
        try{
            stat = conn.prepareStatement(GETONE);
            stat.setString(1, id);
            rs = stat.executeQuery();
            if (rs.next()){
                order = convertir(rs);
            } else{
                throw new DAOException("No se ha encontrado este pedido");
        }
    }catch (SQLException ex){
        throw new DAOException ("Error en SQL", ex);
    } finally {
            if(rs != null){
                try{
                    rs.close();
                } catch(SQLException ex){
                    new DAOException ("Error en SQL", ex);
            }
        }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
    }
    return order;
    }

    @Override
    public ArrayList<Order> readAll() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<Order> orders = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()){
                orders.add(convertir(rs));
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL", ex);
                }
            } 
            if (stat != null) {
                try{
                    stat.close();
                }catch (SQLException ex){
                    new DAOException("Error en SQL", ex);
                }
            }
        }
        return orders;
    }

    @Override
    public void update(Order modificado) throws DAOException {
        PreparedStatement stat=null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setInt(1, modificado.getorderID());
            stat.setString(2, modificado.getProductID());
            stat.setString(3, modificado.getCustomerEmail());
            stat.setInt(4, modificado.getproductQuantity());
            stat.setDouble(5, modificado.getSubtotal());
            stat.setString(6, modificado.getcreationDataTime().toString());
            stat.setInt(7,modificado.gethandlingTime());
            stat.setBoolean(8,modificado.orderSent());

            if (stat.executeUpdate() ==0){
                throw new DAOException("Puede que el pedido no se haya guardado");
        }
        } catch (SQLException ex){
            throw new DAOException ("Error de SQL", ex);
        } finally {
           if (stat !=null){
           try{
           stat.close();
           }catch (SQLException ex) {
               throw new DAOException ("Error de SQL", ex);
                }    
           }
        }        
    }

    @Override
    public void delete(Order eliminado) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, eliminado.getorderID());
            if (stat.executeUpdate() ==0) {
                throw new DAOException ("Puede que el pedido no se haya eliminado");
            }
            } catch (SQLException ex){
                throw new DAOException ("Error de SQL", ex);
            } finally {
                if (stat != null){
                    try{
                        stat.close();
                    }catch (SQLException ex){
                        throw new DAOException("Error de SQL", ex);
                    }
                }
            }
    
            
    }
    
}
