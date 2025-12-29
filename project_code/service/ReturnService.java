package service;

import domain.Product;
import domain.Return;
import repository.ProductRepository;
import repository.ReturnRepository;

public class ReturnService {
    private ProductRepository productRepo;
    private ReturnRepository returnRepo;

    public ReturnService(ProductRepository productRepo, ReturnRepository returnRepo) {
        this.productRepo = productRepo;
        this.returnRepo = returnRepo;
    }

    public void processReturn(String productId, int quantity) {
        Product product = productRepo.findProduct(productId);
        if (product == null) {
            throw new IllegalArgumentException("Invalid product");
        }
        Return r = new Return();
        r.addReturnItem(product, quantity);
        returnRepo.save(r);
    }
}
