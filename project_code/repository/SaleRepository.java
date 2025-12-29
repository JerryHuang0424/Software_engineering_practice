package repository;

import domain.Sale;
import java.util.ArrayList;
import java.util.List;

public class SaleRepository {
    private List<Sale> sales = new ArrayList<>();

    public void save(Sale sale) {
        sales.add(sale);
    }
}
