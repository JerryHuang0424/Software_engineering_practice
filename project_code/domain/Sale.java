package domain;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new SaleItem(product, quantity));
        product.reduceStock(quantity);
    }

    public double calculateTotal() {
        double total = 0;
        for (SaleItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<SaleItem> getItems() {
        return items;
    }
}
