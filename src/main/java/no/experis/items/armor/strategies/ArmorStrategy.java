package main.java.no.experis.items.armor.strategies;

public interface ArmorStrategy {
    int getHealth(int level, double scale);
    int getStrength(int level, double scale);
    int getDexterity(int level, double scale);
    int getIntelligence(int level, double scale);
}
