package Inventory;

import Orders.Order;
import Product_Supplier.Product;
import Product_Supplier.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private List<Product> products;
    private List<Supplier> suppliers;
    private List<Order> orders;

    public Inventory() {
        products = new ArrayList<>();
        suppliers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        if (products.contains(product)) {
            products.remove(product);
        } else {
            throw new IllegalArgumentException("Product not in Inventory");
        }
    }

    protected Product getProductById(String id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)){
                return product;

            }
        }
        throw new IllegalArgumentException("Product not in Inventory");
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void removeSupplier(Supplier supplier) {
        if (suppliers.contains(supplier)) {
            suppliers.remove(supplier);
        } else{
            throw new IllegalArgumentException("Supplier not in Inventory");
        }
    }

    protected Supplier getSupplierById(String id) {
        for (Supplier supplier : suppliers) {
            if (id.equals(supplier.getSupplierId())){
                return supplier;
            }
        }
        throw new IllegalArgumentException("Supplier not in Inventory");
    }

    public void placeOrder(Order order) {
        orders.add(order);
        order.placeOrder();
        Product product = order.getProduct();
        product.removeStock(order.getQuantity());
    }

    public void cancelOrder(String orderId) {
        Order order = orders.stream().filter(o -> Objects.equals(o.getOrderId(), orderId)).findFirst().orElse(null);
        if (order != null) {
            order.cancelOrder();
            Product product = order.getProduct();
            product.addStock(order.getQuantity());
        }
    }

    public String getInventoryReport() {
        StringBuilder report = new StringBuilder("Inventory Report:\n");
        for (Product product : products) {
            report.append(product.getProductInfo()).append("\n");
        }
        return report.toString();
    }

    public String getSupplierReport() {
        StringBuilder report = new StringBuilder("Supplier Report:\n");
        for (Supplier supplier : suppliers) {
            report.append(supplier.getSupplierInfo()).append("\n");
        }
        return report.toString();
    }

    public String getOrderReport() {
        StringBuilder report = new StringBuilder("Order Report:\n");
        for (Order order : orders) {
            report.append(order.getOrderInfo()).append("\n");
        }
        return report.toString();
    }
}
