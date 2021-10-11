package ru.job4j.cache;

public class Emulator {
    public static void main(String[] args) {
        DirFileCache dfc = new DirFileCache("src/main/cache/");
        //System.out.println(dfc.load("text.txt"));
        System.out.println(dfc.get("text.txt"));
    }
}
