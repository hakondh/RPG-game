package main.java.no.experis.items.weapon.strategies;

import main.java.no.experis.hero.ActorStats;

public interface WeaponStrategy {
    int getBaseDamage(int level);
    int getBonusDamage(ActorStats actorStats);
}
