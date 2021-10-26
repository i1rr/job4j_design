package ru.job4j.design.lsp;

import java.util.List;

public interface Storage {
    boolean accept(Food food);

    void allocate(Food food);

    List<Food> getFoodList();
}
