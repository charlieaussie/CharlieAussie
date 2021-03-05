package packageWeapon;

import java.util.Arrays;
import java.util.List;

public class SuperWeapon {
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrostSpellMessage() {
        return frostSpellMessage;
    }

    public void setFrostSpellMessage(String frostSpellMessage) {
        this.frostSpellMessage = frostSpellMessage;
    }

    public String getFireSpellMessage() {
        return fireSpellMessage;
    }

    public void setFireSpellMessage(String fireSpellMessage) {
        this.fireSpellMessage = fireSpellMessage;
    }

    public String getVoidSpellMessage() {
        return voidSpellMessage;
    }

    public void setVoidSpellMessage(String voidSpellMessage) {
        this.voidSpellMessage = voidSpellMessage;
    }

    public String getAttackMessage() {
        return attackMessage;
    }

    public void setAttackMessage(String attackMessage) {
        this.attackMessage = attackMessage;
    }

    public String getAttackMessage1() {
        return attackMessage1;
    }

    public void setAttackMessage1(String attackMessage1) {
        this.attackMessage1 = attackMessage1;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getSpell() {
        return spell;
    }

    public void setSpell(int spell) {
        this.spell = spell;
    }

    public String getAttackMessage2() {
        return attackMessage2;
    }

    public void setAttackMessage2(String attackMessage2) {
        this.attackMessage2 = attackMessage2;
    }

    public int getHealingPotion() {
        return healingPotion;
    }

    public void setHealingPotion(int healingPotion) {
        this.healingPotion = healingPotion;
    }

    public String getHealingPotionName() {
        return healingPotionName;
    }

    public void setHealingPotionName(String healingPotionName) {
        this.healingPotionName = healingPotionName;
    }

    public List<Object> getGivenList() {
        return givenList;
    }

    public void setGivenList(List<Object> givenList) {
        this.givenList = givenList;
    }

    public int getMagicShield() {
        return magicShield;
    }

    public void setMagicShield(int magicShield) {
        this.magicShield = magicShield;
    }

    public int getRaiseUnded() {
        return raiseUnded;
    }

    public void setRaiseUnded(int raiseUnded) {
        this.raiseUnded = raiseUnded;
    }

    public int getSmite() {
        return smite;
    }

    public void setSmite(int smite) {
        this.smite = smite;
    }

    public int getPyromancer() {
        return pyromancer;
    }

    public void setPyromancer(int pyromancer) {
        this.pyromancer = pyromancer;
    }

    public boolean isUnlockMagicShield() {
        return unlockMagicShield;
    }

    public void setUnlockMagicShield(boolean unlockMagicShield) {
        this.unlockMagicShield = unlockMagicShield;
    }

    public boolean isUnlockRaiseUndead() {
        return unlockRaiseUndead;
    }

    public void setUnlockRaiseUndead(boolean unlockRaiseUndead) {
        this.unlockRaiseUndead = unlockRaiseUndead;
    }

    public boolean isUnlockPyromancer() {
        return unlockPyromancer;
    }

    public void setUnlockPyromancer(boolean unlockPyromancer) {
        this.unlockPyromancer = unlockPyromancer;
    }

    public boolean isUnlockSmite() {
        return unlockSmite;
    }

    public void setUnlockSmite(boolean unlockSmite) {
        this.unlockSmite = unlockSmite;
    }

    public boolean isMagickWeapon() {
        return magickWeapon;
    }

    public void setMagickWeapon(boolean magickWeapon) {
        this.magickWeapon = magickWeapon;
    }

    public int damage;
    public String name;
    public String frostSpellMessage;
    public String fireSpellMessage;
    public String voidSpellMessage;
    public String attackMessage;
    public String attackMessage1;
    public int healing;
    public int spell;
   public String attackMessage2;
    public int healingPotion;
    public String healingPotionName;
    List<Object> givenList = Arrays.asList();
    public int magicShield;
    public int raiseUnded;
    public int smite;
    public int pyromancer;
    public boolean unlockMagicShield = false;
    public boolean unlockRaiseUndead = false;
    public boolean unlockPyromancer = false;
    public boolean unlockSmite = false;
    public boolean magickWeapon = true;


}
