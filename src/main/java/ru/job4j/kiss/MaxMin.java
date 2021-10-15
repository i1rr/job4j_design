package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Returns MAX or MIN value from the specified list;
 */

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return maxMinBase(value, comparator, in -> in > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return maxMinBase(value, comparator, in -> in < 0);
    }

    private <T> T maxMinBase(List<T> value,
                             Comparator<T> comparator,
                             Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (T type : value) {
            int comparison = comparator.compare(type, rsl);
            if (predicate.test(comparison)) {
                rsl = type;
            }
        }
        return rsl;
    }
}