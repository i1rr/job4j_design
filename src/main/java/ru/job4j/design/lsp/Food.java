package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food {
    private String name;
    private final LocalDate expiryDate;
    private final LocalDate createDate;
    private float price;
    private final float discount;
    private final long lifetime;

    public Food(String name, LocalDate expiryDate, LocalDate createDate,
                float price, float discount) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
        this.lifetime = ChronoUnit.DAYS.between(createDate, expiryDate);

    }

    public String getName() {
        return name;
    }

    public long getLifetime() {
        return lifetime;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getDaysLeft() {
        return ChronoUnit.DAYS.between(LocalDate.now(), getExpiryDate());
    }

    public float getDifference() {
        return (float) getDaysLeft() / lifetime;
    }
}
