package ru.job4j.design.menu;

import java.util.List;

public class Controller {

    private final Output out;

    public Controller(Output output) {
        this.out = output;
    }

    private void printMenu(List<MenuManager> menuManagerList) {
        out.println("Menu");
        String separator = " -";
        int index = 1;
        for (MenuManager menuManager : menuManagerList) {
            out.println(" " + menuManager.getName() + " " + index);
            menuManager.printSubMenu(index, "",  separator);
            index++;
        }
    }

    public static void main(String[] args) {
        Output out = new OutputConsole();
        MenuManager menu = new Menu(out, "Start", new ActionOne());
        Controller ctrl = new Controller(out);
        menu.add("Start", "New Game", new ActionOne());
        menu.add("Start", "New Life", new ActionOne());
        menu.add("Start", "New Job", new ActionOne());
        menu.add("Start", "New Wife", new ActionOne());
        menu.add("Start", "New Car", new ActionOne());
        menu.add("Start", "New Home", new ActionOne());
        menu.add("Start", "New Year", new ActionOne());
        menu.add("Start", "New Whatever", new ActionOne());

        menu.add("New Game", "Create Yourself", new ActionTwo());
        menu.add("New Game", "Play as Guest", new ActionTwo());
        menu.add("New Game", "Create Wife", new ActionTwo());
        menu.add("New Game", "Create Car", new ActionTwo());
        menu.add("New Game", "Create Home", new ActionTwo());

        menu.add("Create Home", "Villa", new ActionTwo());
        menu.add("Create Home", "House", new ActionTwo());
        menu.add("Create Home", "Apartment", new ActionTwo());

        menu.add("Apartment", "Dvushe4ka", new ActionTwo());

        MenuManager menu2 = new Menu(out, "Exit", new ActionExit());
        List<MenuManager> menuList = List.of(menu, menu2);
        ctrl.printMenu(menuList);
    }
}
