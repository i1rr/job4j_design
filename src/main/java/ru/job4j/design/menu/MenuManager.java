package ru.job4j.design.menu;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuManager {

    private List<MenuManager> subMenuList = new ArrayList<>();
    private Output out;

    public MenuManager(Output out) {
        this.out = out;
    }

    protected abstract String getName();

    protected abstract boolean execute(Input input, Controller controller);

    void printSubMenu(int prevMenuIndex, String legacyBuildIndex, String separator) {
        int currentIndex = 1;
        String legacyIndex = "";
        legacyIndex = legacyBuildIndex.equals("") ? prevMenuIndex + "."
                :  legacyBuildIndex + prevMenuIndex + ".";
        String sep = separator + "---";
        for (MenuManager menuManager : subMenuList) {
            out.println(sep + " " + menuManager.getName() + " " + legacyIndex + currentIndex);
            menuManager.printSubMenu(currentIndex, legacyIndex, sep);
            currentIndex++;
        }
    }

    protected List<MenuManager> getSubMenu() {
        return subMenuList;
    }

    public MenuManager findByName(String menuName) {
        for (MenuManager menuManager : subMenuList) {
            if (menuManager.getName().equals(menuName)) {
                return menuManager;
            }
        }
        return null;
    }
}
