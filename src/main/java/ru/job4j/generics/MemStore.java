package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean rsl = false;
        int memInd = getIndexById(id);

        if (memInd != -1) {
            mem.set(memInd, model);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        boolean rsl = false;
        int memInd = getIndexById(id);

        if (memInd != -1) {
            mem.remove(memInd);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int memInd = getIndexById(id);

        if (memInd != -1) {
            return mem.get(memInd);
        }
        return null;
    }

    @Override
    public int getIndexById(String id) {
        return IntStream.range(0, mem.size())
                .filter(indx -> mem.get(indx).getId().equals(id))
                .findFirst()
                .orElse(-1);
    }
}
