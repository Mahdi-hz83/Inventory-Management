package Orders;

import Product_Supplier.Product;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order order;
    private Product product;

    @Before
    public void setUp() {
        product = new Product("P1", "Product One", "Description of product one", 10, 99.99, "S1");
        order = new Order("O1", product, 3, LocalDateTime.now(), "Placed");
    }

    @Test
    public void testPlaceOrder() {
        order.placeOrder();
        assertEquals("Placed", order.getOrderStatus());
    }

    @Test
    public void testCancelOrder() {
        order.cancelOrder();
        assertEquals("Cancelled", order.getOrderStatus());
    }

    @Test
    public void testUpdateOrderStatus() {
        order.updateOrderStatus("Shipped");
        assertEquals("Shipped", order.getOrderStatus());
        System.out.println(order.getOrderInfo());
    }
}