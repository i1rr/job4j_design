package ru.job4j.serialization.xml;

public class Laptop {
    private final String name;
    private final String model;
    private final float serial;

    public Laptop(String name, String model, float serial) {
        this.name = name;
        this.model = model;
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Laptop{"
                + "name='" + name + '\''
                + ", model='" + model + '\''
                + ", serial=" + serial
                + '}';
    }
}
