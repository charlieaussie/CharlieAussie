package package1;

import package2.SuperClass;
import packageWeapon.SuperArmor;
import packageWeapon.SuperWeapon;

public class Player {
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int hp;
    public SuperWeapon currentWeapon;
    public SuperClass currentClass;
    public SuperArmor currentArmor;

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int[] getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int[] currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int[] getRequiredXP() {
        return requiredXP;
    }

    public void setRequiredXP(int[] requiredXP) {
        this.requiredXP = requiredXP;
    }

    public String getCritName() {
        return critName;
    }

    public void setCritName(String critName) {
        this.critName = critName;
    }

    public int getCriticalStrike() {
        return criticalStrike;
    }

    public void setCriticalStrike(int criticalStrike) {
        this.criticalStrike = criticalStrike;
    }

    public int goldCoins = 25;
    public String lastName;
    public String name;
    public int xp = 0;
    public int level = 1;
    public int[] currentLevel = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public int[] requiredXP = {0, 6, 13, 20, 25, 30, 35, 40, 45, 50};
    public String critName = "bonus damage";
    public int criticalStrike = 0;


    public Player(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}
