package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final ArrayList<Food> list = new ArrayList<>();

    private void applyDiscount(Food food) {
        float currentPrice = food.getPrice();
        food.setPrice(currentPrice - food.getDiscount() / 100 * currentPrice);
    }

    @Override
    public boolean accept(Food food) {
        float difference = food.getDifference();

        if (difference <= 0.75 && difference >= 0.25) {
            return true;
        } else if (difference < 0.25 && difference > 0) {
            applyDiscount(food);
            return true;
        }
        return false;
    }

    @Override
    public void allocate(Food food) {
        list.add(food);
    }

    @Override
    public List<Food> getFoodList() {
        return list;
    }
}
