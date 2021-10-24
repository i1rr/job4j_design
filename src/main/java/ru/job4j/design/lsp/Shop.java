package ru.job4j.design.lsp;

import java.util.ArrayList;

public class Shop implements Storage {
    private ArrayList<Food> list = new ArrayList<>();

    public ArrayList<Food> getList() {
        return list;
    }

    @Override
    public void allocate(Food food) {
        list.add(food);
    }
}
