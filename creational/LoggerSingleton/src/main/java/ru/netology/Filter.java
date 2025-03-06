package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int x : source) {
            if (x >= threshold) {
                result.add(x);
                logger.log(String.format("Элемент %d проходит", x));
                count++;
            } else {
                logger.log(String.format("Элемент %d не проходит", x));
            }
        }
        logger.log(String.format("Прошло фильтр %d элемента из %d", count, source.size()));
        return result;
    }
}
