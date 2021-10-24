package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Food {
    private String name;
    private LocalDate expiryDate;
    private LocalDate createDate;
    private float price;
    private float discount;
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

    public void setDiscount(float discount) {
        this.discount = price - discount / 100 * price;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public float getDiscount() {
        return discount;
    }
}
