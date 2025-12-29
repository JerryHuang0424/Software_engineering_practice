package domain;

import java.util.ArrayList;
import java.util.List;

public class Return {
    private List<ReturnItem> items = new ArrayList<>();

    public void addReturnItem(Product product, int quantity) {
        ReturnItem item = new ReturnItem(product, quantity);
        item.processReturn();
        items.add(item);
    }
}
