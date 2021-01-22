package main.java.no.experis;

import main.java.no.experis.factories.HeroFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroStatsTest {
    HeroFactory heroFactory = new HeroFactory();
    Hero boromir = heroFactory.getHero("Boromir",HeroClass.WARRIOR);
    HeroStats heroStats = boromir.getHeroStats();

    /*For now, only the setters are tested. The setters
    are more complex than the getters, and the getters will
    indirectly be tested through the testing of the setters.*/

    @Test
    void testSetHealth() {
        heroStats.setHealth(heroStats.getHealth() + 30);
        assertEquals(heroStats.getHealth(), 180);
    }

    @Test
    void testSetStrength() {
        heroStats.setStrength(heroStats.getStrength() + 5);
        assertEquals(15, heroStats.getStrength());
    }

    @Test
    void testSetIntelligence() {
        heroStats.setIntelligence(heroStats.getIntelligence() + 1);
        assertEquals(2, heroStats.getIntelligence());
    }

    @Test
    void testSetDexterity() {
        heroStats.setDexterity(heroStats.getDexterity() + 2);
        assertEquals(5, heroStats.getDexterity());
    }
}