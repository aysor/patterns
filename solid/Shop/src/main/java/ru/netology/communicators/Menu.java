package ru.netology.communicators;

import java.util.Arrays;
import java.util.Optional;

public enum Menu {
    SHOW_ALL(1),
    FILTER(2),
    ADD(3),
    REMOVE(4),
    SHOW_BASKET(5),
    PAY(6),
    EXIT(7);
    private final int number;

    Menu(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Optional<Menu> nameOf(int number) {
        return Arrays.stream(values())
                .filter(m -> m.number == number)
                .findFirst();
    }
}
