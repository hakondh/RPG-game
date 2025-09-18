package main.java.no.experis;

import main.java.no.experis.factories.ActorFactory;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.items.weapon.Weapon;
import main.java.no.experis.items.weapon.WeaponClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    ActorFactory heroFactory = new ActorFactory();
    Actor gimli = heroFactory.getHero("Gimli", ActorClass.WARRIOR);
    Weapon axe = new Weapon("Glóin's Axe", WeaponClass.MELEE, 1);

    @Test
    void testGetName(){
        assertEquals("Gimli", gimli.getName());
    }

    @Test
    void testGetHeroSlots() {
        assertNotNull(gimli.getActorSlots());
    }

    @Test
    void testGetHeroStats() {
        assertNotNull(gimli.getActorStats());
    }

    @Test
    void testGiveXP() {
        gimli.giveXP(100);
        assertEquals(2, gimli.getLevel());// Check that the level has gone up to 2
        // Check stats
        assertEquals(180, gimli.getActorStats().getBaseHealth());
        assertEquals(15, gimli.getActorStats().getStrength());
        assertEquals(5, gimli.getActorStats().getDexterity());
        assertEquals(2, gimli.getActorStats().getIntelligence());
    }

    @Test
    void testDisplayStats() {
        gimli.equip(axe);
    }

    @Test
    void testEquip(){
        gimli.equip(axe);
        assertEquals(32, gimli.getActorStats().getDamage());
    }

    @Test
    void testAttack() {
        gimli.attack();
    }
}