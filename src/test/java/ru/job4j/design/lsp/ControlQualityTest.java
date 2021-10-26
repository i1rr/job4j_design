package ru.job4j.design.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    @Test
    public void whenFoodGoesToWarehouse() {
        Food carrot = new Carrot("Carrot",
                LocalDate.of(2022, Month.JANUARY, 10),
                LocalDate.of(2021, Month.OCTOBER, 10),
                25, 10);

        ControlQuality cq = new ControlQuality(List.of(new Shop(), new Warehouse(), new Trash()));
        cq.executeAllocation(List.of(carrot));

        assertThat(cq.getStorageList().get(1).getFoodList().get(0).getName(), is("Carrot"));
    }

    @Test
    public void whenFoodGoesToStore() {
        Food dumplings = new Dumplings("Dumplings",
                LocalDate.of(2021, Month.NOVEMBER, 30),
                LocalDate.of(2021, Month.OCTOBER, 1),
                25, 10);

        ControlQuality cq = new ControlQuality(List.of(new Shop(), new Warehouse(), new Trash()));
        cq.executeAllocation(List.of(dumplings));

        assertThat(cq.getStorageList().get(0).getFoodList().get(0).getName(), is("Dumplings"));
    }

    @Test
    public void whenFoodGoesToStoreWithDiscount() {
        Food dumplings = new Dumplings("Dumplings",
                LocalDate.of(2021, Month.OCTOBER, 30),
                LocalDate.of(2021, Month.OCTOBER, 1),
                25, 10);

        ControlQuality cq = new ControlQuality(List.of(new Shop(), new Warehouse(), new Trash()));
        cq.executeAllocation(List.of(dumplings));

        assertThat(cq.getStorageList().get(0).getFoodList().get(0).getName(), is("Dumplings"));
        assertThat(cq.getStorageList().get(0).getFoodList().get(0).getPrice(), is(22.5f));
    }

    @Test
    public void whenFoodGoesToBin() {
        Food noodles = new Noodles("Noodles",
                LocalDate.of(2021, Month.OCTOBER, 1),
                LocalDate.of(2020, Month.OCTOBER, 1),
                25, 10);

        ControlQuality cq = new ControlQuality(List.of(new Shop(), new Warehouse(), new Trash()));
        cq.executeAllocation(List.of(noodles));

        assertThat(cq.getStorageList().get(2).getFoodList().get(0).getName(), is("Noodles"));
    }
}