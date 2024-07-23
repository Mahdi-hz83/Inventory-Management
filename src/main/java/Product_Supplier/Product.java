package Product_Supplier;

import java.util.Objects;

public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private int quantity;
    private double price;
    private String supplierId;

    public Product(String productId, String productName, String productDescription, int quantity, double price, String supplierId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void addStock(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        } else{
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    public void removeStock(int quantity) {
        if (quantity > 0) {
            this.quantity -= quantity;
        } else{
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    public void updatePrice(double price) {
        if (price > 0) {
            this.price += price;
        } else{
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId , product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    public String getProductInfo() {
        return "Product ID: " + productId + "\nName: " + productName + "\nProduct Description: " + productDescription +
                "\nQuantity: " + quantity + "\nPrice: " + price + "\nSupplier ID: " + supplierId;
    }
}
