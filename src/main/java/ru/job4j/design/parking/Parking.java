package ru.job4j.design.parking;

import java.util.List;

public interface Parking {
    Vehicle[] availableCarSpots();

    Vehicle[] availableTruckSpots();

    boolean park(Vehicle vehicle);

    boolean park(List<Vehicle> vehicleList);
}
