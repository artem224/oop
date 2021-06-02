package game;

import java.io.Serializable;

public class BasicPropertyHero implements Serializable {
    private double damage;
    private double health;
    private int intelligence;
    private int defense;

    public BasicPropertyHero() {
        damage = 0;
        health = 0;
        intelligence = 0;
        defense = 0;
    }

    public BasicPropertyHero(double damage, double health, int intelligence, int defense) {
        this.damage = damage;
        this.health = health;
        this.intelligence = intelligence;
        this.defense = defense;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return damage + "-%-" + health + "-%-" + intelligence + "-%-" + defense;
    }
}
