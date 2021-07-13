package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Spell {
    private final boolean castable;
    private final int coolDown;
    private final Fireball fireball;
    private final String[] log;

    public Spell(boolean castable, int coolDown, Fireball fireball, String... log) {
        this.castable = castable;
        this.coolDown = coolDown;
        this.fireball = fireball;
        this.log = log;
    }

    @Override
    public String toString() {
        return "Spell{"
                + "castable=" + castable
                + ", coolDown=" + coolDown
                + ", fireball=" + fireball
                + ", log=" + Arrays.toString(log)
                + '}';
    }

    public static void main(String[] args) {
        final Spell spell = new Spell(true, 30, new Fireball(200),
                "18.02.2021::22:18", "18.02.2021::22:22");

        //object to JSON string
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(spell));

        final String spellJson =
                "{"
                        + "\"castable\":true,"
                        + "\"coolDown\":30,"
                        + "\"fireball\":"
                        + "{"
                        + "\"damage\":\"200\""
                        + "},"
                        + "\"log\":"
                        + "[\"18.02.2021::22:18\", \"18.02.2021::22:22\"]"
                        + "}";
        final Spell spellMod = gson.fromJson(spellJson, Spell.class);
        System.out.println(spellMod);
    }
}
