package main.java.no.experis.factories;

import main.java.no.experis.Hero;
import main.java.no.experis.HeroClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroFactoryTest {
    HeroFactory heroFactory = new HeroFactory();

    @Test
    void testGetWarriorHero() {
        Hero aragorn = heroFactory.getHero("Aragorn", HeroClass.WARRIOR);
        assertNotNull(aragorn);
    }
    @Test
    void testGetMageHero() {
        Hero gandalf = heroFactory.getHero("Gandalf", HeroClass.MAGE);
        assertNotNull(gandalf);
    }
    @Test
    void testGetRangerHero() {
        Hero legolas = heroFactory.getHero("Legolas", HeroClass.RANGER);
        assertNotNull(legolas);
    }
}