package ru.job4j.design.parking;

public class Car implements Vehicle {
    private final int size = 1;

    @Override
    public int vehicleType() {
        return size;
    }
}
