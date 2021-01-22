package main.java.no.experis.game;

import main.java.no.experis.Hero;
import main.java.no.experis.factories.HeroFactory;
import main.java.no.experis.HeroClass;

public class RolePlayingGame {
    public void run() {
        HeroFactory heroFactory = new HeroFactory();
        Hero fingolfin = heroFactory.getHero("Fingolfin", HeroClass.WARRIOR);
        Hero morgoth = heroFactory.getHero("Morgoth", HeroClass.MAGE);
    }
}
