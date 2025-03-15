package ru.netology;

import ru.netology.communicators.Communicator;
import ru.netology.communicators.ConsoleCommunicator;
import ru.netology.productSets.Shop;
import ru.netology.products.Food;
import ru.netology.products.HouseHold;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.<Food>fillProducts("data/food.json", Food[].class);
        shop.<HouseHold>fillProducts("data/household.json", HouseHold[].class);
        Communicator communicator = new ConsoleCommunicator(shop);
        communicator.start();
    }
}