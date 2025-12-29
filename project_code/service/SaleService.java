package service;

import domain.Product;
import domain.Sale;
import repository.ProductRepository;
import repository.SaleRepository;

public class SaleService {
    private Sale sale = new Sale();
    private ProductRepository productRepo;
    private SaleRepository saleRepo;

    public SaleService(ProductRepository productRepo, SaleRepository saleRepo) {
        this.productRepo = productRepo;
        this.saleRepo = saleRepo;
    }

    public void addItem(String productId, int quantity) {
        Product product = productRepo.findProduct(productId);
        if (product == null || product.getStockQuantity() < quantity) {
            throw new IllegalArgumentException("Invalid product or insufficient stock");
        }
        sale.addItem(product, quantity);
    }

    public double completeSale() {
        double total = sale.calculateTotal();
        saleRepo.save(sale);
        return total;
    }
}
