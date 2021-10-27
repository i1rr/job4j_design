package ru.job4j.design.menu;

import java.util.List;

public class Menu extends MenuManager {
    private final String name;

    public Menu(Output out, String name) {
        super(out);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute(Input input, Controller controller) {
        return false;
    }

    @Override
    protected List<MenuManager> getSubMenu() {
        return super.getSubMenu();
    }
}
