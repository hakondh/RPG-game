package main.java.no.experis.hero;


import main.java.no.experis.items.armor.Armor;
import main.java.no.experis.items.weapon.Weapon;

public class HeroSlots {
    // A Hero has nothing equipped on creation
    private Weapon weapon = null;
    private Armor head = null;
    private Armor body = null;
    private Armor legs = null;

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getHead() {
        return head;
    }

    public Armor getBody() {
        return body;
    }

    public Armor getLegs() {
        return legs;
    }

    public void setWeapon(Weapon weapon) { this.weapon = weapon; }

    public void setHead(Armor head) {
        this.head = head;
    }

    public void setBody(Armor body) {
        this.body = body;
    }

    public void setLegs(Armor legs) {
        this.legs = legs;
    }
}
