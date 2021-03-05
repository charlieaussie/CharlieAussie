package packageWeapon;

public class WeaponStaff extends SuperWeapon {
    public WeaponStaff() {
        name = "Staff";
        damage = 9;
        frostSpellMessage = "Frost Bolt";
        fireSpellMessage = "Fire Bolt";
        voidSpellMessage = "Void Bolt";
        spell = spell + damage;
        magicShield = 0;
        raiseUnded = 14;
        pyromancer = 12;
        smite = 10;
        unlockMagicShield = false;
        unlockPyromancer = false;
        unlockSmite = false;
        unlockRaiseUndead = false;
       magickWeapon = true;

    }
}
