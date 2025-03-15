package ru.netology.communicators;

import ru.netology.productSets.Basket;
import ru.netology.productSets.Shop;

import java.util.*;

public class ConsoleCommunicator implements Communicator {
    Shop shop;
    Scanner sc = null;
    Basket basket;

    public ConsoleCommunicator(Shop shop) {
        this.shop = shop;
        basket = new Basket(shop);
    }

    public void start() {
        sc = new Scanner(System.in);
        System.out.println("\nДобро пожаловать!");
        boolean finish = false;
        while (!finish) {
            showMenu();
            int input = Integer.parseInt(sc.nextLine());
            Menu menuNumber = Menu.nameOf(input).get();
            switch (menuNumber) {
                case SHOW_ALL:
                    System.out.println(shop.getInfo(""));
                    break;
                case FILTER:
                    filterMenu();
                    break;
                case ADD:
                    addProductMenu();
                    break;
                case REMOVE:
                    removeProductMenu();
                    break;
                case SHOW_BASKET:
                    System.out.println(basket.getInfo(""));
                    break;
                case PAY:
                    basket.pay();
                    break;
                case EXIT:
                    finish = true;
                    break;
            }
        }
        sc.close();
        System.out.println("\nСпасибо за покупку!\n");
    }

    private void showMenu() {
        System.out.println("\nОсновное меню:\n" +
                Menu.SHOW_ALL.getNumber() + ". Показать весь доступный ассортимент\n" +
                Menu.FILTER.getNumber() + ". Отфильтровать по ключевым словам\n" +
                Menu.ADD.getNumber() + ". Добавить товар\n" +
                Menu.REMOVE.getNumber() + ". Удалить товар из корзины\n" +
                Menu.SHOW_BASKET.getNumber() + ". Показать корзину\n" +
                Menu.PAY.getNumber() + ". Оплатить\n" +
                Menu.EXIT.getNumber() + ". Выйти из магазина");
    }

    private void filterMenu() {
        System.out.print("Введите через пробел ключевые слова для фильтрации: ");
        String filter = sc.nextLine();
        System.out.println(shop.getInfo(filter));
    }

    private void addProductMenu() {
        System.out.print("Введите через пробел индекс продукта и количество для добавления: ");
        String input = sc.nextLine();
        String[] data = input.split(" ");
        try {
            int idx = Integer.parseInt(data[0]);
            int qty = Integer.parseInt(data[1]);
            basket.add(idx, qty);
        } catch (Exception e) {
            System.out.println("Неверно введены параметры для добавления продукта.");
        }
    }

    private void removeProductMenu() {
        System.out.print("Введите через пробел номер продукта (в корзине) и количество для удаления: ");
        String[] input = sc.nextLine().split(" ");
        try {
            int idx = Integer.parseInt(input[0]);
            int qty = Integer.parseInt(input[1]);
            basket.remove(idx, qty);
        } catch (Exception e) {
            System.out.println("Неверно введены параметры для удаления продукта.");
        }
    }
}
