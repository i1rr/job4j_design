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

    protected abstract boolean execute(Action actionName);

    void printSubMenu(int prevMenuIndex, String legacyBuildIndex, String separator) {
        int currentIndex = 1;
        String legacyIndex = "";
        legacyIndex = legacyBuildIndex.equals("") ? prevMenuIndex + "."
                : legacyBuildIndex + prevMenuIndex + ".";
        String sep = separator + "---";
        for (MenuManager menuManager : subMenuList) {
            out.println(sep + " " + menuManager.getName() + " " + legacyIndex + currentIndex);
            menuManager.printSubMenu(currentIndex, legacyIndex, sep);
            currentIndex++;
        }
    }

    public boolean add(String parentName, String childName, Action actionName) {
        if (getName().equals(parentName)) {
            subMenuList.add(new Menu(out, childName, actionName));
            return true;
        } else {
            for (MenuManager menu : subMenuList) {
                if (menu.getName().equals(parentName)) {
                    menu.subMenuList.add(new Menu(out, childName, actionName));
                    return true;
                }
                menu.add(parentName, childName, actionName);
            }
        }
        return false;
    }
}
