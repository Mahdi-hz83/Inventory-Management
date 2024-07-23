package Inventory;

import Orders.Order;
import Product_Supplier.Product;
import Product_Supplier.Supplier;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    private Inventory inventory;
    private Product product;
    private Supplier supplier;
    private Order order;

    @Before
    public void setUp() {
        this.inventory = new Inventory();
        this.product = new Product("P1", "Product One", "Description of product one", 10, 99.99, "S1");
        this.supplier = new Supplier("S1", "Supplier One", "contact@supplierone.com");
        this.order = new Order("O1", product, 3, LocalDateTime.now(), "Placed");
        inventory.addProduct(product);
        inventory.addSupplier(supplier);
        inventory.placeOrder(order);
    }

    @Test
    public void testAddProduct() {
        Product product2 = new Product("P2", "Product Two", "Description of product two", 10, 99.99, "S2");
        inventory.addProduct(product2);
        assertTrue(inventory.getProducts().contains(product2));
    }

    @Test
    public void testRemoveProduct() {
        inventory.removeProduct(product);
        assertFalse(inventory.getProducts().contains(product));
    }

    @Test
    public void testGetProductById() {
        inventory.addProduct(product);
        Product foundProduct = inventory.getProductById("P1");
        assertEquals(product, foundProduct);
    }

    @Test
    public void testAddSupplier() {
        Supplier supplier2 = new Supplier("S2", "Supplier Two", "contact@supplierone.com");
        inventory.addSupplier(supplier2);
        assertTrue(inventory.getSuppliers().contains(supplier));
    }

    @Test
    public void testRemoveSupplier() {
        inventory.removeSupplier(supplier);
        assertFalse(inventory.getSuppliers().contains(supplier));
    }

    @Test
    public void testGetSupplierById() {
        inventory.addSupplier(supplier);
        Supplier foundSupplier = inventory.getSupplierById("S1");
        assertEquals(supplier, foundSupplier);
    }

    @Test
    public void testPlaceOrder() {
        assertEquals(7, product.getQuantity());
        assertTrue(inventory.getOrders().contains(order));
    }

    @Test
    public void testCancelOrder() {
        inventory.cancelOrder("O1");
        assertEquals(10, product.getQuantity());
        assertEquals("Cancelled", order.getOrderStatus());
        System.out.println("Order Information: \n" + order.getOrderInfo());
        System.out.println("------------------------------------------------------------");
        System.out.println("Product Information: \n" + product.getProductInfo());
        System.out.println("------------------------------------------------------------");
        System.out.println("Supplier Information: \n" + supplier.getSupplierInfo());
        System.out.println("------------------------------------------------------------");
        System.out.println("Inventory Information: \n" + inventory.getInventoryReport());
    }
}