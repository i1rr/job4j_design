package ru.job4j.design.parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingMallExternalTest {

    @Test
    public void when3car3trucksCanFit() {
        Parking parking = new ParkingMall(3, 3);
        List<Vehicle> vehicles = List.of(
                new Car(), new Car(), new Car(),
                new Truck(2), new Truck(2), new Truck(3));
        assertTrue(parking.park(vehicles));
    }

    @Test
    public void whenCarsMoreThanSpots() {
        Parking parking = new ParkingMall(3, 3);
        List<Vehicle> vehicles = List.of(
                new Car(), new Car(), new Car(), new Car(),
                new Truck(2), new Truck(3), new Truck(2));
        assertFalse(parking.park(vehicles));
    }

    @Test
    public void whenNoTruckSpotsButTrucksCanFit() {
        Parking parking = new ParkingMall(5, 0);
        List<Vehicle> vehicles = List.of(
                new Truck(2), new Truck(3));
        assertTrue(parking.park(vehicles));
    }

    @Test
    public void whenFreeTruckSpotsButNotForCars() {
        Parking parking = new ParkingMall(3, 3);
        List<Vehicle> vehicles = List.of(
                new Car(), new Car(), new Car(),
                new Car());
        assertFalse(parking.park(vehicles));
    }
}