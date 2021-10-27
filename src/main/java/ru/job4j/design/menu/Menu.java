package ru.job4j.design.menu;

public class Menu extends MenuManager {
    private final String name;
    private Action action;

    public Menu(Output out, String name, Action action) {
        super(out);
        this.name = name;
        this.action = action;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected boolean execute(Action actionName) {
        return actionName.act();
    }
}
