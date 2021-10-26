package ru.job4j.design.parking;

import java.util.List;

public class ParkingMall implements Parking {
    private final Vehicle[] carSpots;
    private final Vehicle[] truckSpots;
    private int carCount = 0;
    private int truckCount = 0;

    public ParkingMall(int carSpots, int truckSpots) {
        this.carSpots = new Vehicle[carSpots];
        this.truckSpots = new Vehicle[truckSpots];
    }

    @Override
    public Vehicle[] availableCarSpots() {
        return carSpots;
    }

    @Override
    public Vehicle[] availableTruckSpots() {
        return truckSpots;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        int vehicleSize = vehicle.getVehicleSize();
        if (vehicleSize == 1 && availableCarSpots().length - carCount > 0) {
            carSpots[carCount++] = vehicle;
            return true;
        } else if (vehicleSize > 1
                && availableTruckSpots().length - truckCount > 0) {
            truckSpots[truckCount++] = vehicle;
            return true;
        } else if (vehicleSize > 1
                && availableCarSpots().length - carCount >= vehicleSize) {
            for (int i = 0; i < vehicleSize; i++) {
                carSpots[carCount++] = vehicle;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean park(List<Vehicle> vehicleList) {
        for (Vehicle veh : vehicleList) {
            if (!park(veh)) {
                return false;
            }
        }
        return true;
    }
}
