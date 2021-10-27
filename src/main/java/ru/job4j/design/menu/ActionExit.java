package ru.job4j.design.menu;

public class ActionExit implements Action {
    @Override
    public boolean act() {
        System.out.println("It was nice too meet ya. Byyyyee");
        return false;
    }
}
