package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age = -1;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public boolean hasAddress() {
        return city != null;
    }

    public OptionalInt getAge() {
        if (age < 0) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(age);
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
        if (age >= 0) {
            age++;
        }
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(name + " " + surname);
        if (hasAge()) {
            info.append(" (" + age + ")");
        }
        if (hasAddress()) {
            info.append(" из " + city);
        }
        return info.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(city)
                .setAge(0);
    }
}
