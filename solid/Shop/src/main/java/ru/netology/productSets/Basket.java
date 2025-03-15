package ru.netology.productSets;

import java.util.HashMap;
import java.util.Map;

public class Basket extends ProductSet {
    Map<Integer, Integer> ids = new HashMap<>();        //[shop_index, basket_index]
    Shop shop;

    public Basket(Shop shop){
        this.shop = shop;
    }

    public void add(int idx, int qty){
        int resultQty = qty;
        if (products.contains(shop.getProduct(idx))) {
            resultQty = resultQty + getProduct(ids.get(idx)).getQuantity();
        }
        if (resultQty > shop.getProduct(idx).getQuantity()) {
            System.out.printf("Доступно лишь %d позиций товара. Вы не можете взять %d\n", shop.getProduct(idx).getQuantity(), resultQty);
            return;
        }
        if (!products.contains(shop.getProduct(idx))) {
            products.add(shop.getProduct(idx));
            ids.put(idx, products.size());
        }
        getProduct(ids.get(idx)).setQuantity(resultQty);
    }

    public void remove(int idx, int qty){
        int actualQty = getProduct(idx).getQuantity();
        if (qty > actualQty) {
            System.out.println("В корзине недостаточное количество товара для удаления");
        }else if(qty == actualQty){
            products.remove(idx - 1);
            int idToRemove = -1;
            for(int shopId : ids.keySet()){
                if(ids.get(shopId) == idx){
                    idToRemove = shopId;
                } else if(ids.get(shopId) > idx){
                    ids.put(shopId, ids.get(shopId) - 1);
                }
            }
            ids.remove(idToRemove);
        }else {
            getProduct(idx).setQuantity(actualQty - qty);
        }
    }

    public void pay(){
        //Оплата, списание из ассортимента магазина
        for(Integer shopId : ids.keySet()){
            shop.remove(shopId, getProduct(ids.get(shopId)).getQuantity());
        }
    }

    @Override
    public String getInfo(String filter) {
        return "Ваша корзина:\n" + super.getInfo(filter);
    }
}
