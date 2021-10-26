package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final ArrayList<Food> list = new ArrayList<>();

    @Override
    public boolean accept(Food food) {
        return food.getDifference() > 0.75;
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
