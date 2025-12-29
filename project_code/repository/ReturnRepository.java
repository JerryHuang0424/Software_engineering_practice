package repository;

import domain.Return;
import java.util.ArrayList;
import java.util.List;

public class ReturnRepository {
    private List<Return> returns = new ArrayList<>();

    public void save(Return r) {
        returns.add(r);
    }
}
