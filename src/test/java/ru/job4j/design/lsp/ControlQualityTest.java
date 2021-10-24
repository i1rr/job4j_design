package ru.job4j.design.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    @Test
    public void whenFoodGoesToWarehouse() {
        Food carrot = new Carrot("Carrot",
                LocalDate.of(2022, Month.JANUARY, 10),
                LocalDate.of(2021, Month.OCTOBER, 10),
                25, 0);

        ControlQuality cq = new ControlQuality(new Warehouse(), new Shop(), new Trash());
        cq.executeAllocation(carrot, 10);

        assertThat(cq.getWarehouse().getList().get(0).getName(), is("Carrot"));
    }

    @Test
    public void whenFoodGoesToStore() {
        Food dumplings = new Dumplings("Dumplings",
                LocalDate.of(2021, Month.NOVEMBER, 30),
                LocalDate.of(2021, Month.OCTOBER, 1),
                25, 0);

        ControlQuality cq = new ControlQuality(new Warehouse(), new Shop(), new Trash());
        cq.executeAllocation(dumplings, 10);

        assertThat(cq.getShop().getList().get(0).getName(), is("Dumplings"));
    }

    @Test
    public void whenFoodGoesToStoreWithDiscount() {
        Food dumplings = new Dumplings("Dumplings",
                LocalDate.of(2021, Month.OCTOBER, 30),
                LocalDate.of(2021, Month.OCTOBER, 1),
                25, 0);

        ControlQuality cq = new ControlQuality(new Warehouse(), new Shop(), new Trash());
        cq.executeAllocation(dumplings, 10);

        assertThat(cq.getShop().getList().get(0).getName(), is("Dumplings"));
        assertThat(cq.getShop().getList().get(0).getDiscount(), is(22.5f));
    }

    @Test
    public void whenFoodGoesToBin() {
        Food noodles = new Noodles("Noodles",
                LocalDate.of(2021, Month.OCTOBER, 1),
                LocalDate.of(2020, Month.OCTOBER, 1),
                25, 0);

        ControlQuality cq = new ControlQuality(new Warehouse(), new Shop(), new Trash());
        cq.executeAllocation(noodles, 10);

        assertThat(cq.getTrash().getList().get(0).getName(), is("Noodles"));
    }
}