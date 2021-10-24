package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ControlQuality {
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    public ControlQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void executeAllocation(Food food, int discountInPercent) {
        long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), food.getExpiryDate());
        float difference = (float) daysLeft / food.getLifetime();

        if (difference > 0.75) {
            warehouse.allocate(food);
        } else if (difference <= 0.75 && difference >= 0.25) {
            shop.allocate(food);
        } else if (difference < 0.25 && difference > 0) {
            food.setDiscount(discountInPercent);
            shop.allocate(food);
        } else if (difference <= 0) {
            trash.allocate(food);
        }
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }
}