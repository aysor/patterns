package ru.netology;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String city;

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Unacceptable age\n");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Person build() {
        StringBuilder ex = new StringBuilder();
        if (name == null) {
            ex.append("Person cannot be created: must be defined parameter 'name'");
        }
        if (surname == null) {
            ex.append("\nPerson cannot be created: must be defined parameter 'surname'\n");
        }
        if (!ex.isEmpty()) {
            throw new IllegalStateException(ex.toString());
        }
        Person p = (age < 0) ? new Person(name, surname) : new Person(name, surname, age);
        if (city != null) {
            p.setAddress(city);
        }
        return p;
    }

}
