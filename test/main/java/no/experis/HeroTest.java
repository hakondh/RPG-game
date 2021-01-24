package main.java.no.experis;

import main.java.no.experis.factories.HeroFactory;
import main.java.no.experis.hero.Hero;
import main.java.no.experis.hero.HeroClass;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    HeroFactory heroFactory = new HeroFactory();
    Hero gimli = heroFactory.getHero("Gimli", HeroClass.WARRIOR);
    Weapon axe = new Weapon("Glóin's Axe", WeaponClass.MELEE, 1);

    @Test
    void testGetName(){
        assertEquals("Gimli", gimli.getName());
    }

    @Test
    void testGetHeroSlots() {
        assertNotNull(gimli.getHeroSlots());
    }

    @Test
    void testGetHeroStats() {
        assertNotNull(gimli.getHeroStats());
    }

    @Test
    void testGiveXP() {
        gimli.giveXP(100);
        assertEquals(2, gimli.getLevel());// Check that the level has gone up to 2
        // Check stats
        assertEquals(180, gimli.getHeroStats().getHealth());
        assertEquals(15, gimli.getHeroStats().getStrength());
        assertEquals(5, gimli.getHeroStats().getDexterity());
        assertEquals(2, gimli.getHeroStats().getIntelligence());
    }

    @Test
    void testDisplayStats() {
        gimli.equip(axe);
    }

    @Test
    void testEquip(){
        gimli.equip(axe);
        assertEquals(32, gimli.getHeroStats().getDamage());
    }
}