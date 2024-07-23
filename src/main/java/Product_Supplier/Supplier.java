package Product_Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supplier {
    private String supplierId;
    private String supplierName;
    private String email;
    private List<Product> productSupplied;

    public Supplier(String supplierId, String supplierName, String email) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.email = email;
        this.productSupplied = new ArrayList<>();
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProductSupplied() {
        return productSupplied;
    }

    public void setProductSupplied(List<Product> productSupplied) {
        this.productSupplied = productSupplied;
    }

    public void addProduct(Product product) {
        productSupplied.add(product);
    }

    public void removeProduct(Product product) {
        productSupplied.remove(product);
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getSupplierInfo(){
        return "Supplier ID: " + supplierId + "\nName: " + supplierName + "\nContact Info: " + email +
                "\nProducts Supplied: " + productSupplied.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(supplierId , supplier.supplierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId);
    }
}
