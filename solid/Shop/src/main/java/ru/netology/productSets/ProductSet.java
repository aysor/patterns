package ru.netology.productSets;

import ru.netology.products.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ProductSet {
    protected List<Item> products = new ArrayList<>();

    public String getInfo(String filter) {
        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < products.size(); p++) {
            if (products.get(p).getQuantity() > 0) {
                boolean contains = false;
                if (!filter.isEmpty()) {
                    List<String> words = Arrays.stream(filter.toLowerCase().split(" ")).toList();
                    String significant = products.get(p).getSignificantFields();
                    for (String w : words) {
                        if (significant.contains(w)) {
                            contains = true;
                        }
                        ;
                    }
                }
                if (filter.isEmpty() || contains) {
                    sb.append(String.format("%d. %s.............%d%s\n", p + 1, products.get(p), products.get(p).getQuantity(), products.get(p).getUnit()));
                }
            }
        }
        return sb.toString();
    }

    public Item getProduct(int id) {
        return products.get(id - 1);
    }

    public abstract void remove(int idx, int qty);

    public abstract void add(int idx, int qty);

}
