package repository;

import domain.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private Map<String, Product> products = new HashMap<>();

    public ProductRepository() {
        products.put("P001", new Product("P001", "Milk", 2.5, 50));
        products.put("P002", new Product("P002", "Bread", 1.8, 30));
        products.put("P003", new Product("P003", "Apple", 0.5, 100));
    }

    public Product findProduct(String id) {
        return products.get(id);
    }

    public void showAllProducts() {
        products.values().forEach(System.out::println);
    }
}
