package bog_models;


import java.time.LocalDateTime;




public class Order {
    public static int orderIDnumber;
    private int orderID;
    private String productID;
    private String customerEmail;
    private int productQuantity;
    private double subtotal;
    private LocalDateTime creationDateTime;
    private int handlingTime;
    private boolean isSent;

    // CONSTRUCTOR
    public Order(String productID, String customerEmail, int productQuantity, double subtotal, int hadlingTime) {
        this.productID = productID;
        this.customerEmail = customerEmail;
        this.productQuantity = productQuantity; 
        this.subtotal = subtotal;
        this.handlingTime = hadlingTime;
        

    }
    public Order(int orderID, String productID, String customerEmail, int productQuantity, double subtotal, String creationDateTime ,int hadlingTime) {
        this.orderID = orderID;
        this.productID = productID;
        this.customerEmail = customerEmail;
        this.productQuantity = productQuantity; 
        this.subtotal = subtotal;
        this.handlingTime = hadlingTime;
        this.creationDateTime = LocalDateTime.parse(creationDateTime) ;

    }
        

    // // Generador de Order ID
    // public static int orderIdGenerator(){
    //     orderIDnumber++;
    //     return orderIDnumber;
    // }
    
    // CHECKERS - Comprueban las políticas de negocio y calculan resultados
    public boolean isCancellable() {

        return !isSent; // Si esta enviado, no se puede cancelar. Así de simple
    }


    // public double calculateShipping() {
    //     final double customerDiscount = this.customerEmail.getCustomerDiscount() / 100;
    //     final double discount = customerDiscount > 0 ? productID.getShippingFee() * customerDiscount : productID.getShippingFee();
    //     final double shippingWithDiscount = productID.getShippingFee() - discount;
    //     return shippingWithDiscount;
    // }

    // @Test
    // public void testCalculateShipping(){ //Para que esto funcione debemos pasar el producto 002A y un costumer.Premium.
    //     assertEquals(1.6d, calculateShipping(), 0.01); //El 0.001 es el margen de error que tienen los float
    // }

    // public double calculateOrderTotal() {
    //     final double productPrice = this.productQuantity * this.productID.getPrice();
    //     final double shipping = calculateShipping();
    //     final double orderTotal = productPrice + shipping;
    //     return orderTotal;
    // }

   

    public boolean orderSent() {
        // Creamos la fecha en la que el pedido estará lista
        LocalDateTime handlingResult = creationDateTime.plusDays(handlingTime);

        // Pasada esa fecha el articulo se habrá enviado
        if (LocalDateTime.now().compareTo(handlingResult) > 0) {
            isSent = true;
        } else {
            isSent = false;
        }

        return isSent;
    }

    
    
    // GETTERS & SETTERS

    public int getorderID() {
        return orderID;
    }

    public void setorderID(int orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String product) {
        this.productID = product;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomer(String customer) {
        this.customerEmail = customer;
    }

    public int getproductQuantity() {
        return productQuantity;
    }

    public void setproductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public LocalDateTime getcreationDataTime() {
        return creationDateTime;
    }

    public void setcreationDataTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public int gethandlingTime() {
        return handlingTime;
    }

    public void sethandlingTime(int handlingTime) {
        this.handlingTime = handlingTime;
    }


    public boolean isSent() {
        return isSent;
    }


    public void setSent(boolean isSent) {
        this.isSent = isSent;
    }


    @Override
    public String toString() {
        return "Order [creationDataTime=" + creationDateTime + ", customer=" + customerEmail + ", handlingTime="
                + handlingTime + ", product="
                + productID + ", productQuantity=" + productQuantity + ", orderID="
                + orderID
                + ", subtotal=" + subtotal + "]";
    }

}
