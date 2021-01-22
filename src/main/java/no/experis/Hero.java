package main.java.no.experis;

import main.java.no.experis.strategies.LevelUpStrategy;


public class Hero {
    private final String name;
    private final HeroClass heroClass;
    private HeroStats heroStats;
    private HeroSlots heroSlots = new HeroSlots();
    private LevelUpStrategy levelUpStrategy;
    private int level = 1;
    private int xp = 0;

    public Hero(String name, HeroClass heroClass, HeroStats heroStats, LevelUpStrategy levelUpStrategy) {
        this.name = name;
        this.heroClass = heroClass;
        this.heroStats = heroStats;
        this.levelUpStrategy = levelUpStrategy;
    }

    public String getName() {
        return this.name;
    }

    public HeroSlots getHeroSlots() {return this.heroSlots;}

    public HeroStats getHeroStats() {return this.heroStats;}

    public void levelUp() {
        this.levelUpStrategy.levelUp(this.heroStats);
    }
}
