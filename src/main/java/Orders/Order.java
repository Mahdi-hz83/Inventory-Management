package Orders;

import Product_Supplier.Product;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private String orderId;
    private Product product;
    private int quantity;
    private LocalDateTime orderDate;
    private String orderStatus;

    public Order(String orderId, Product product, int quantity, LocalDateTime orderDate, String orderStatus) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void placeOrder(){
        this.orderStatus = "Placed";
    }

    public void cancelOrder(){
        this.orderStatus = "Cancelled";
    }

    public void updateOrderStatus(String newStatus){
        this.orderStatus = newStatus;
    }

    public String getOrderInfo(){
        return "Order ID: " + getOrderId() + "\nProduct: " + product.getProductName() + "\nQuantity: " + getQuantity() +
                "\nOrder Date: " + getOrderDate() + "\nStatus: " + getOrderStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
