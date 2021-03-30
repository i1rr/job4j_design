package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class TriggerTesta {
    @Test
    public void test() {
        Assert.assertEquals(2, new Trigger().someLogic());
    }

}