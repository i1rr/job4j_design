package ru.job4j.design.menu;

import java.util.Scanner;

public class InputConsole implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}

