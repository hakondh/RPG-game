package main.java.no.experis.factories;

import main.java.no.experis.hero.Actor;
import main.java.no.experis.hero.ActorClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroFactoryTest {
    ActorFactory heroFactory = new ActorFactory();

    @Test
    void testGetWarriorHero() {
        Actor aragorn = heroFactory.getHero("Aragorn", ActorClass.WARRIOR);
        assertNotNull(aragorn);
    }
    @Test
    void testGetMageHero() {
        Actor gandalf = heroFactory.getHero("Gandalf", ActorClass.MAGE);
        assertNotNull(gandalf);
    }
    @Test
    void testGetRangerHero() {
        Actor legolas = heroFactory.getHero("Legolas", ActorClass.RANGER);
        assertNotNull(legolas);
    }
}