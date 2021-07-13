package ru.job4j.serialization.json;

public class Fireball {
    private final int damage;

    public Fireball(int dmg) {
        this.damage = dmg;
    }

    @Override
    public String toString() {
        return "Fireball{"
                + "damage=" + damage
                + '}';
    }
}
