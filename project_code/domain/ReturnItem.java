package domain;

public class ReturnItem {
    private Product product;
    private int quantity;

    public ReturnItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void processReturn() {
        product.increaseStock(quantity);
    }
}
