package ru.job4j.design.lsp;

import java.util.List;

public class ControlQuality {

    private final List<Storage> storageList;

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void executeAllocation(List<Food> foodList) {
        foodList.forEach(food ->
                storageList.forEach(storage -> {
                    if (storage.accept(food)) {
                        storage.allocate(food);
                    }
                }));
    }

    public List<Storage> getStorageList() {
        return storageList;
    }
}