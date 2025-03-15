package ru.netology.products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("Food")
public class Food extends Item {
    protected double weight;

    public Food() {
    }

    @JsonCreator
    public Food(String name, double price, String mfr, double rating, int code, double quantity, String unit, double weight) {
        super(name, price, mfr, rating, weight, code, quantity, unit);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s ('%s') по цене %.2f₽/%s", name, mfr, price, unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, mfr, rating, code, unit, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Food objFood = (Food) obj;
        return name == objFood.name
                && price == objFood.price
                && mfr == objFood.mfr
                && rating == objFood.rating
                && code == objFood.code
                && unit == objFood.unit
                && weight == objFood.weight;
    }
}
