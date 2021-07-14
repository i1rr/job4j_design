package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Device {
    private boolean inStock;
    private int quantity;
    private final String type;
    private final Laptop laptop;
    private String[] tag;

    public Device(boolean inStock, int quantity, String type, Laptop laptop, String... tag) {
        this.inStock = inStock;
        this.quantity = quantity;
        this.type = type;
        this.laptop = laptop;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Device{"
                + "inStock=" + inStock
                + ", quantity=" + quantity
                + ", type='" + type + '\''
                + ", laptop=" + laptop
                + ", tag=" + Arrays.toString(tag)
                + '}';
    }

    public static void main(String[] args) {
        final Device mbPro = new Device(true,
                21,
                "MAC",
                new Laptop("MacBook Pro", "2020", 8839295),
                "Mac", "Book", "Apple");
    }
}
