package ru.job4j.design.menu;

public class ActionTwo implements Action {
    @Override
    public boolean act() {
        System.out.println("Action TWO!!!");
        return true;
    }
}
