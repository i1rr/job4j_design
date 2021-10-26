package ru.job4j.design.parking;

import java.util.List;

public class ParkingMallExternal implements Parking {
    private final int carSpots;
    private final int truckSpots;

    public ParkingMallExternal(int carSpots, int truckSpots) {
        this.carSpots = carSpots;
        this.truckSpots = truckSpots;
    }

    @Override
    public int availableCarSpots() {
        return carSpots;
    }

    @Override
    public int availableTruckSpots() {
        return truckSpots;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        return false;
    }

    @Override
    public boolean park(List<Vehicle> vehicleList) {
        return false;
    }
}
