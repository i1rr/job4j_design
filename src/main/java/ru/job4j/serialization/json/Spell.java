package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        //JSONObject from json-String
        JSONObject jsonFBall = new JSONObject("{\"damage\":\"+200\"}");

        //JSON Array out of ArrayList
        List<String> list = new ArrayList<>();
        list.add("18.02.2021::22:18");
        list.add("18.02.2021::22:22");
        JSONArray jsonLog = new JSONArray(list);

        //JSONObject using put
        final Spell spell = new Spell(true, 30, new Fireball(200),
                "18.07.2021::21:18", "18.07.2021::21:19");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("castable", spell.castable);
        jsonObject.put("coolDown", spell.coolDown);
        jsonObject.put("fireball", jsonFBall);
        jsonObject.put("log", jsonLog);

        //JSON Obj to Console
        System.out.println(jsonObject);
        System.out.println(new JSONObject(spell));

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
