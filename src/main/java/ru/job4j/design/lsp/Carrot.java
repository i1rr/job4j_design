package ru.job4j.design.lsp;

import java.time.LocalDate;

public class Carrot extends Food {
    public Carrot(String name, LocalDate expiryDate, LocalDate createDate,
                  float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
