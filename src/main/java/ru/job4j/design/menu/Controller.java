package ru.job4j.design.menu;

import java.util.List;

public class Controller {

    private Output out;

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
        MenuManager menu = new Menu(out, "Start");
        Controller ctrl = new Controller(out);
        menu.getSubMenu().add(new Menu(out, "New Game"));
        menu.getSubMenu().add(new Menu(out, "New Life"));
        menu.getSubMenu().add(new Menu(out, "New Job"));
        menu.getSubMenu().add(new Menu(out, "Old Game"));
        menu.getSubMenu().add(new Menu(out, "Old Life"));
        menu.getSubMenu().add(new Menu(out, "Old Job"));
        menu.findByName("New Game").getSubMenu().add(new Menu(out, "Create Yourself"));
        menu.findByName("New Game").getSubMenu().add(new Menu(out, "Play as Guest"));
        menu.findByName("New Life").getSubMenu().add(new Menu(out, "Create Yourself"));
        menu.findByName("New Life").getSubMenu().add(new Menu(out, "Play as Guest"));
        menu.findByName("New Job").getSubMenu().add(new Menu(out, "Create Yourself"));
        menu.findByName("New Job").getSubMenu().add(new Menu(out, "Play as Guest"));
        menu.findByName("New Game").findByName("Play as Guest").getSubMenu()
                .add(new Menu(out, "Male"));
        menu.findByName("New Game").findByName("Play as Guest").getSubMenu()
                .add(new Menu(out, "Female"));
        menu.findByName("New Game").findByName("Play as Guest").findByName("Female")
                .getSubMenu().add(new Menu(out, "Svetlana"));

        MenuManager menu2 = new Menu(out, "Exit");
        List<MenuManager> menuList = List.of(menu, menu2);
        ctrl.printMenu(menuList);
    }
}
