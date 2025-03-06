package ru.netology;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        Person petr = new PersonBuilder()
                .setName("Петя")
                .setSurname("Романов")
                .setAge(18)
                .setAddress("Петербург")
                .build();
        Person katerina = new PersonBuilder()
                .setName("Катя")
                .setSurname("Романова")
                .build();
        Person aleks = petr.newChildBuilder()
                .setName("Алеша")
                .build();
        System.out.println("У " + petr + " есть сын, " + aleks);
        System.out.println(katerina);


        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}