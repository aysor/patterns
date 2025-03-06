package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        System.out.println();
        logger.log(String.format("Запускаем программу"));
        Scanner sc = new Scanner(System.in);

        logger.log(String.format("Просим пользователя ввести входные данные для списка"));
        System.out.print("Введите размер списка: ");
        int size = sc.nextInt();
        System.out.print("Введите верхнюю границу для значений: ");
        int max = sc.nextInt();

        logger.log(String.format("Создаём и наполняем список"));
        List<Integer> digits = generateList(size, max);

        logger.log(String.format("Просим пользователя ввести входные данные для фильтрации"));
        System.out.print("Введите порог для фильтра: ");
        int threshold = sc.nextInt();

        logger.log(String.format("Запускаем фильтрацию"));
        Filter filter = new Filter(threshold);
        List<Integer> filtered = filter.filterOut(digits);

        logger.log(String.format("Выводим результат на экран"));
        System.out.print("Отфильтрованный список: ");
        filtered.forEach(x -> System.out.print(x + " "));
        System.out.println();

        logger.log(String.format("Завершаем программу"));

        sc.close();
    }

    private static List<Integer> generateList(int size, int max) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        System.out.print("Вот случайный список: ");
        while (result.size() < size) {
            int x = random.nextInt(max);
            result.add(x);
            System.out.print(x + " ");
        }
        System.out.println();
        return result;
    }
}
