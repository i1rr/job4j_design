package ru.job4j.design.menu;

public class ActionOne implements Action {
    @Override
    public boolean act() {
        System.out.println("ACTION OOONE!!!");
        return true;
    }
}
