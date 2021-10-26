package ru.job4j.design.parking;

public class Truck implements Vehicle {
    private final int size;

    public Truck(int size) {
        if (size < 2) {
            System.out.println(
                    "Truck size can not be lower than 2.\n"
                    + "Minimum size of '2' is set.");
            this.size = 2;
        } else {
            this.size = size;
        }
    }

    @Override
    public int getVehicleSize() {
        return size;
    }
}
