package ru.netology.productSets;

import com.google.gson.Gson;
import ru.netology.products.Item;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Shop extends ProductSet {
    public <T extends Item> void fillProducts(String json, Class<T[]> clazz) {
        try {
            try (Reader reader = new FileReader(json)) {
                T[] pJson = new Gson().fromJson(reader, clazz);
                products.addAll(Arrays.asList(pJson));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getInfo(String filter) {
        return "Ассортимент магазина:\n" + super.getInfo(filter);
    }

    @Override
    public void remove(int idx, int qty) {
        int old = getProduct(idx).getQuantity();
        getProduct(idx).setQuantity(old - qty);
    }

    @Override
    public void add(int idx, int qty) {
        //возврат товара в магазин
    }
}
