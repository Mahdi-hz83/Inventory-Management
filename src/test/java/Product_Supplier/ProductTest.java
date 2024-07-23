package Product_Supplier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product("P1", "Product One", "Description of product one", 10, 99.99, "S1");
    }

    @Test
    public void testAddStockPositive(){
        product.addStock(10);
        assertEquals(20 , product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddStockNegative(){
        product.addStock(-10);
    }

    @Test
    public void testRemoveStockPositive(){
        product.removeStock(5);
        assertEquals(5 , product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveStockNegative(){
        product.removeStock(-10);
    }

    @Test
    public void testUpdatePricePositive(){
        product.updatePrice(79.90);
        assertEquals(79.90 , product.getPrice());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePriceNegative(){
        product.updatePrice(-79.90);
    }
}