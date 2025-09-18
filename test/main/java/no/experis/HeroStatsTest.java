package main.java.no.experis;

import main.java.no.experis.factories.ActorFactory;
import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import main.java.no.experis.hero.ActorStats;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroStatsTest {
    ActorFactory heroFactory = new ActorFactory();
    Actor boromir = heroFactory.getHero("Boromir", ActorClass.WARRIOR);
    ActorStats heroStats = boromir.getActorStats();

    /*For now, only the setters are tested. The setters
    are more complex than the getters, and the getters will
    indirectly be tested through the testing of the setters.*/

    @Test
    void testSetHealth() {
        heroStats.setHealth(heroStats.getBaseHealth() + 30);
        assertEquals(heroStats.getBaseHealth(), 180);
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