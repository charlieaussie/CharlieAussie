package packageWeapon;

public class WeaponGospel extends SuperWeapon {
    public WeaponGospel() {
        name = "Gospel";
        damage = 4;
        healing = 4;
        frostSpellMessage = "Frost Bolt";
        fireSpellMessage = "Fire Bolt";
        voidSpellMessage = "Void Bolt";
        spell = spell + damage;
        magicShield = 0;
        raiseUnded = 14;
        pyromancer = 12;
        smite = 10;
       unlockMagicShield = false;
       unlockRaiseUndead = false;
       unlockPyromancer = false;
        unlockSmite = false;
        magickWeapon = true;

    }
}
