package ru.netology.products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.netology.Rateable;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Food.class, name = "Food"),
        @JsonSubTypes.Type(value = HouseHold.class, name = "HouseHold")}
)
public abstract class Item implements Rateable {
    protected String name;
    protected double price;
    protected String mfr;
    protected double rating;
    protected int code;
    protected String unit;

    protected int quantity;

    public Item() {
    }

    @JsonCreator
    public Item(String name, double price, String mfr, double rating, double weight, int code, double quantity, String unit) {
        this.name = name;
        this.price = price;
        this.mfr = mfr;
        this.rating = rating;
        this.code = code;
        this.unit = unit;
    }

    public void setQuantity(int qty) {
        quantity = qty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void rate(int rate) {

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, mfr, rating, code, unit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Item objFood = (Item) obj;
        return name == objFood.name
                && price == objFood.price
                && mfr == objFood.mfr
                && rating == objFood.rating
                && code == objFood.code
                && unit == objFood.unit;
    }

    public String getSignificantFields() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(mfr);
        return sb.toString().toLowerCase();
    }
}
