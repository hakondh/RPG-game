package main.java.no.experis.factories;

import main.java.no.experis.hero.Hero;
import main.java.no.experis.hero.HeroClass;
import main.java.no.experis.hero.HeroStats;
import main.java.no.experis.constants.*;
import main.java.no.experis.hero.strategies.LevelUpMage;
import main.java.no.experis.hero.strategies.LevelUpRanger;
import main.java.no.experis.hero.strategies.LevelUpStrategy;
import main.java.no.experis.hero.strategies.LevelUpWarrior;

public class HeroFactory {
    public Hero getHero(String name, HeroClass heroClass) {
        HeroStats heroStats;
        LevelUpStrategy levelUpStrategy;

        switch (heroClass) {
            case WARRIOR -> {
                heroStats = new HeroStats(
                        WarriorConstants.START_HP,
                        WarriorConstants.START_STR,
                        WarriorConstants.START_DEX,
                        WarriorConstants.START_INT
                );
                levelUpStrategy = new LevelUpWarrior();
                return new Hero(name, heroClass, heroStats, levelUpStrategy);
            }
            case RANGER -> {
                heroStats = new HeroStats(
                        RangerConstants.START_HP,
                        RangerConstants.START_STR,
                        RangerConstants.START_DEX,
                        RangerConstants.START_INT
                );
                levelUpStrategy = new LevelUpRanger();
                return new Hero(name, heroClass, heroStats, levelUpStrategy);
            }
            case MAGE -> {
                heroStats = new HeroStats(
                        MageConstants.START_HP,
                        MageConstants.START_STR,
                        MageConstants.START_DEX,
                        MageConstants.START_INT
                );
                levelUpStrategy = new LevelUpMage();
                return new Hero(name, heroClass, heroStats, levelUpStrategy);
            }
        }
        return null;
    }
}
