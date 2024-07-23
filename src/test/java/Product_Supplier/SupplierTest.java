package Product_Supplier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SupplierTest {
    private Supplier supplier;
    private Product product;

    @Before
    public void setUp() {
        supplier = new Supplier("S1", "Supplier One", "contact@supplierone.com");
        product = new Product("P1", "Product One", "Description of product one", 10, 99.99, "S1");
    }

    @Test
    public void testAddProduct() {
        supplier.addProduct(product);
        assertTrue(supplier.getProductSupplied().contains(product));
    }

    @Test
    public void testRemoveProduct() {
        supplier.addProduct(product);
        supplier.removeProduct(product);
        assertFalse(supplier.getProductSupplied().contains(product));
    }

    @Test
    public void testUpdateContactInfo() {
        supplier.updateEmail("newcontact@supplierone.com");
        assertEquals("newcontact@supplierone.com", supplier.getEmail());
        System.out.println(supplier.getSupplierInfo());
    }
}