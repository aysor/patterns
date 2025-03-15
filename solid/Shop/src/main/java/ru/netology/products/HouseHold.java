package ru.netology.products;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeName("HouseHold")
public class HouseHold extends Item {
    protected String type;

    public HouseHold() {
    }

    @JsonCreator
    public HouseHold(String name, double price, String mfr, double rating, double weight, int code, double quantity, String unit, String type) {
        super(name, price, mfr, rating, weight, code, quantity, unit);
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s ('%s') по цене %.2f₽/%s", name, type, mfr, price, unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, mfr, rating, code, unit, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        HouseHold objFood = (HouseHold) obj;
        return name == objFood.name
                && price == objFood.price
                && mfr == objFood.mfr
                && rating == objFood.rating
                && code == objFood.code
                && unit == objFood.unit
                && type == objFood.type;
    }

    public String getSignificantFields() {
        String base = super.getSignificantFields();
        return base + " " + type;
    }
}
