package main.java.no.experis;

import main.java.no.experis.factories.HeroFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    HeroFactory heroFactory = new HeroFactory();
    Hero gimli = heroFactory.getHero("Gimli", HeroClass.WARRIOR);

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
    void testLevelUp() {
        gimli.levelUp();
        assertEquals(180, gimli.getHeroStats().getHealth());
        assertEquals(15, gimli.getHeroStats().getStrength());
        assertEquals(5, gimli.getHeroStats().getDexterity());
        assertEquals(2, gimli.getHeroStats().getIntelligence());
    }
}