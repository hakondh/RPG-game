package main.java.no.experis.items;

import main.java.no.experis.items.strategies.EquipStrategy;

// Every item that can be equipped has to implement this interface
public interface Equipable {
    EquipStrategy getEquipStrategy();
    String getName();
    void displayStats();
}
