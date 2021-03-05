package packageWeapon;

import java.util.Collections;

public class WeaponLongSword extends SuperWeapon
{
    public WeaponLongSword(){
        damage = 8;
        name = "Long Sword";
        attackMessage1 = "End Cleaver Attack!";
        attackMessage = "clang cling";
        attackMessage2 = "whirlwind slash";
      givenList = Collections.singletonList(attackMessage);
    }
}
