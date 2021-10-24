package ru.job4j.design.lsp;

import java.time.LocalDate;

public class Noodles extends Food {
    public Noodles(String name, LocalDate expiryDate,
                   LocalDate createDate, float price, float discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
