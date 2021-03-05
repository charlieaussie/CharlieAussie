package package1;

import package2.*;
import packageWeapon.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Story {
    //Classes
    Player player = new Player("Charlie", "Emmure");
    SuperMonster monster;
    SuperClass superClass;
    ShopItems shopItems = new ShopItems();
    SuperArmor superArmor;
    MailHelmet mailHelmet = new MailHelmet();
    ClothHelmet clothHelmet = new ClothHelmet();
    HealingPotion healingPotion = new HealingPotion();
    WeaponLongSword weaponLongSword = new WeaponLongSword();
    private int buy = 0;
    private boolean warrior = false;
    private boolean mage = false;
    private boolean priest = false;
    private String spellMessage;
    private String weaponAttackMessage;
    private int passedPotion = 0;

    //constructor
    public Story(SuperClass superClass, SuperArmor superArmor) {
        this.superClass = superClass;
        this.superArmor = superArmor;
    }

    // method for start value stats
    public void defaultSetup() throws IOException {
        //Player Hp
        player.level = 1;
        player.hp = player.getHp() + 15;
        player.goldCoins = 25;
        player.currentWeapon = new WeaponKnife();
        System.out.println(player.getName() + " " + player.getLastName() + " Your starting weapon is a " + player.currentWeapon.name
                + "\nIts starting damage is " + player.currentWeapon.getDamage() + " damage. Your starting health is " + player.getHp() +
                "\nYour staring level is " + player.getLevel());
        System.out.println();
        System.out.println();
        selectClass();

    }

    private void classSetup() {

    }

    // Setup method for different classes
    private void priestSetup() throws IOException {
        player.currentClass = new Mage();
        priest = true;
        player.currentWeapon = new WeaponStaff();
        System.out.println(player.name + " Your starting weapon is a " + player.currentWeapon.name);
        System.out.println(player.name + "You choose to play as a " + player.currentClass.name +
                " Your starting damage is: " + (player.currentClass.startingDamage + player.currentWeapon.damage)
                + " And your starting health is " + (player.currentClass.startingHealth + player.hp));
        System.out.println("Bonus HP is:" + player.currentClass.startingHealth + " And Bonus damage is:" + player.currentWeapon.damage +
                " For playing as a " + player.currentClass.name);
        player.hp = (player.hp + 2);
        player.currentWeapon.damage = (player.currentWeapon.damage + 9);
        map();
    }

    private void mageSetup() throws IOException {
        player.currentClass = new Mage();
        mage = true;
        player.currentWeapon = new WeaponStaff();
        System.out.println(player.name + " Your starting weapon is a " + player.currentWeapon.name);
        System.out.println(player.name + " You choose to play as a " + player.currentClass.name +
                " Your starting damage is: " + (player.currentClass.startingDamage + player.currentWeapon.damage)
                + " And your starting health is " + (player.currentClass.startingHealth + player.hp));
        System.out.println("Bonus HP is:" + player.currentClass.startingHealth + " And Bonus damage is:" + player.currentWeapon.damage +
                " For playing as a " + player.currentClass.name);
        player.hp = (player.hp + 2);
        player.currentWeapon.damage = (player.currentWeapon.damage + 9);
        map();

    }

    private void warriorSetup() throws IOException {
        player.currentClass = new Warrior();
        warrior = true;
        player.currentWeapon = new WeaponLongSword();
        System.out.println(player.name + " Your starting weapon is a " + player.currentWeapon.name);
        System.out.println(player.name + " You choose to play as a " + player.currentClass.name + " " +
                "Your starting damage is " + (player.currentClass.startingDamage + player.currentWeapon.damage)
                + " And your starting health is: " + (player.currentClass.startingHealth + player.hp));
        System.out.println("Bonus HP is:" + player.currentClass.startingHealth + " And Bonus damage is:" + player.currentWeapon.damage +
                " For playing as a " + player.currentClass.name);
        player.hp = player.hp + 10;
        player.currentWeapon.damage = (player.currentWeapon.damage + 8);
        map();
    }


    // method for selecting a class
    private void selectClass() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("________________________________________________________________________");
        System.out.println("ADVENTURE GAME");
        System.out.println("Hello! Please pick you class");
        System.out.println("________________________________________________________________________");
        System.out.println("________________________________________________________________________");
        System.out.println("Press(1) for Warrior\nPress(2) for Mage\nPress(3) for Priest");
        System.out.println("________________________________________________________________________");
        int choose = 0;
        try {
            choose = sc.nextInt();
        } catch (Exception e) {
            System.out.println("You entered bad data.\nRun the program again.");
            System.out.println("\f");
            selectClass();
        }
        // Menu and stats for different classes
        switch (choose) {
            case 1:
                warriorSetup();
                break;
            case 2:
                mageSetup();
                break;
            case 3:
                priestSetup();
                break;
            default:
                System.out.println("Wrong Command please try again");
                selectClass();
                break;
        }
    }

    private void enemyGenerator() throws IOException {
        int i = new java.util.Random().nextInt(100) + 1;
        if (i < 50) {
            monster = new MonsterGoblin();
        } else {
            monster = new MonsterTroll();
        }
        battleMenu();
    }

    private void mageAndPriestBattle() throws IOException {
        while (monster.monsterHealth > 1 && player.hp > 1) {
            int j = new java.util.Random().nextInt(30) + 1;
            if (j > 0 && j <= 10) {
                weaponAttackMessage = player.currentWeapon.getVoidSpellMessage();
            } else if (j > 11 && j <= 20) {
                weaponAttackMessage = player.currentWeapon.getFrostSpellMessage();
            } else if (j > 21 && j <= 30) {
                weaponAttackMessage = player.currentWeapon.getFireSpellMessage();
            }
            int randomMonsterDamage = new Random().nextInt(monster.getMonsterDamage());
            int spellDamage = new Random().nextInt(player.currentWeapon.spell) + 1;
            int f = new Random().nextInt(100) + 1;
            if (f >= 70 && f <= 100) {
                spellMessage = player.currentWeapon.fireSpellMessage;
                System.out.println("You Attack " + "\"" + player.currentWeapon.fireSpellMessage + "\"" + " at " + monster.getName() + " Dealing " + ": " + (spellDamage + player.criticalStrike) + player.critName + " damage ");
                monster.monsterHealth -= spellDamage + player.criticalStrike;
                System.out.println("The " + monster.getName() + " is dealing " + randomMonsterDamage + " damage to you " + "\"" + monster.monsterAttackMessage + "\"");
                player.hp = player.hp - randomMonsterDamage;
                if (player.hp < 1) {
                    graveyard();
                }
                battleMenu();

            } else if (f >= 40 && f < 70) {
                System.out.println("You Attack " + "\"" + player.currentWeapon.getVoidSpellMessage() + "\"" + " " + monster.getName() + " Dealing " + spellDamage + " damage ");
                monster.monsterHealth -= spellDamage;
                System.out.println("The " + monster.getName() + " is dealing " + randomMonsterDamage + " damage to you " + "\"" + monster.getMonsterAttackMessage() + "\"");
                player.hp = player.hp - randomMonsterDamage;
                if (player.hp < 1) {
                    graveyard();
                }
                battleMenu();
            } else if (f > 0 && f < 40) {
                System.out.println("You Attack " + "\"" + player.currentWeapon.getFireSpellMessage() + "\"" + " " + monster.getName() + " Dealing " + spellDamage + " damage ");
                monster.monsterHealth -= spellDamage;
                System.out.println("The " + monster.getName() + " is dealing " + randomMonsterDamage + " damage to you " + "\"" + monster.getMonsterAttackMessage() + "\"");
                player.hp = player.hp - randomMonsterDamage;
                if (player.hp < 1) {
                    graveyard();
                }
                battleMenu();

            }
        }
        defeatedMonster();

    }

    private void warriorBattle() throws IOException {
        int j = new java.util.Random().nextInt(30) + 1;
        if (j > 0 && j <= 10) {
            weaponAttackMessage = player.currentWeapon.getAttackMessage();
        } else if (j > 11 && j <= 20) {
            weaponAttackMessage = player.currentWeapon.getAttackMessage1();
        } else if (j > 21 && j <= 30) {
            weaponAttackMessage = player.currentWeapon.getAttackMessage2();
        }

        int randomMonsterDamage = new java.util.Random().nextInt(monster.getMonsterDamage());
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        int f = new java.util.Random().nextInt(100) + 1;
        if (f < 10) {
            player.criticalStrike = player.criticalStrike + playerDamage;
            player.critName = "bonus damage";
            System.out.println("You Attack " + "\"" + weaponAttackMessage + "\"" + " at " + monster.getName() + " Dealing " + ": " + (playerDamage + player.criticalStrike) + player.critName + " damage ");

            monster.monsterHealth -= playerDamage + player.criticalStrike;
            System.out.println("The " + monster.getName() + " is dealing " + randomMonsterDamage + " damage to you " + "\"" + monster.monsterAttackMessage + "\"");
            player.hp = player.hp - randomMonsterDamage;

        } else {
            System.out.println("You Attack " + "\"" + weaponAttackMessage + "\"" + " " + monster.getName() + " Dealing " + playerDamage + " damage ");
            monster.monsterHealth -= playerDamage;

            System.out.println("The " + monster.getName() + " is dealing " + randomMonsterDamage + " damage to you " + "\"" + monster.getMonsterAttackMessage() + "\"");
            player.hp = player.hp - randomMonsterDamage;
            if (player.hp < 1) {
                graveyard();
            }
        }

    }

    private void battleMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (monster.monsterHealth > 1 && player.hp > 1) {
            System.out.println("The enemy is a " + monster.name + " It has " + monster.monsterHealth + " hp");
            System.out.println("=====================================================================================================");
            System.out.println("Your HP is : " + player.getHp() + " available healing potion is:" + player.currentWeapon.healingPotion);
            System.out.println("=====================================================================================================");
            System.out.println("What do you want to do?");
            System.out.println("Press(1) Attack\nPress(2) Healing Potion\nPress(3) Run Away\nPress(4) to cast a spell");
            int choice = 0;
            try {

                choice = sc.nextInt();
                if (warrior && choice == 4) {
                    System.out.println("A warrior cannot cast spells try again");
                    battleMenu();
                }
            } catch (Exception e) {
                System.out.println("Invalid command ");
                battleMenu();
            }
            switch (choice) {
                case 1:
                    if (mage || priest) {
                        System.out.println("Unable command must attack with magic only");
                        battleMenu();
                    }
                    warriorBattle();
                    break;
                case 2:
                    if (player.currentWeapon.healingPotion >= 1) {
                        healYourself();
                    } else {
                        System.out.println("You don't have any healing potions left");
                        battleMenu();
                    }
                    break;
                case 3:
                    System.out.println("You run away ");
                    map();
                    break;
                case 4:
                    if (warrior) {
                        System.out.println(player.currentClass.name + " is unable to cast spells");
                        battleMenu();
                    }
                    mageAndPriestBattle();
                default:
                    System.out.println("Invalid command try again");
                    battleMenu();
                    break;

            }
        }
        defeatedMonster();
    }

    private void healYourself() throws IOException {
        int randomHeal = new java.util.Random().nextInt(healingPotion.getHealingPotion());
        System.out.println("You use a " + healingPotion.getHealingPotionName());
        player.hp = player.hp + player.currentWeapon.healingPotion + randomHeal;
        randomHeal = randomHeal + player.currentWeapon.getHealingPotion();
        System.out.println("Healing you for " + randomHeal);
        player.currentWeapon.healingPotion--;
        battleMenu();

    }

    private void defeatedMonster() throws IOException {
        System.out.println("You defeated the " + monster.getName());
        passedPotion++;
        int reward = player.goldCoins + 20;
        player.xp = player.xp + monster.monsterXp;
        System.out.println("You get " + reward + " gold coins\nYou gain " + (player.xp) + " XP");
        player.level = player.level + 1;
        System.out.println("Your level is know " + player.level);
        levelUp();

    }

    private void levelUp() throws IOException {

        if (player.xp == player.requiredXP[0]) {
            player.level = player.currentLevel[0];
        } else if (player.xp == player.requiredXP[1]) {
            player.level = player.currentLevel[1];
        } else if (player.xp == player.requiredXP[2]) {
            player.level = player.currentLevel[2];
        } else if (player.xp == player.requiredXP[3]) {
            player.level = player.currentLevel[3];
        } else if (player.xp == player.requiredXP[4]) {
            player.level = player.currentLevel[4];
        } else if (player.xp == player.requiredXP[5]) {
            player.level = player.currentLevel[5];
        } else if (player.xp == player.requiredXP[6]) {
            player.level = player.currentLevel[6];
        } else if (player.xp == player.requiredXP[7]) {
            player.level = player.currentLevel[7];
        } else if (player.xp == player.requiredXP[8]) {
            player.level = player.currentLevel[8];
        } else if (player.xp == player.requiredXP[9]) {
            player.level = player.currentLevel[9];
        }
        map();
    }

    private void graveyard() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You Died\nGame Over ");
        System.out.println("Want to play again (Yes) (No)");

        String playAgain = null;
        try {
            playAgain = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid command try again");
        }

        assert playAgain != null;
        if (playAgain.equalsIgnoreCase("yes")) {
            defaultSetup();
        } else if (playAgain.equalsIgnoreCase("no")) {
            System.exit(0);
        } else {
            System.out.println("Invalid command try again");
            graveyard();
        }
    }

    // this map lets player select a destination
    private void map() throws IOException {
        // bufferReader works a a scanner but is faster
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("________________________________________________________________________");
        System.out.println("You look at the map please select your travel destination");
        System.out.println("Press(n) FOR NORTH (Cave)\nPress(s) FOR SOUTH (Town)\nPress(e) FOR EAST (Forest)\nPress(w) FOR WEST (River)");
        System.out.println("If you play as a Mage or Priest you can go to magic school Press (magic) to enter school. ");
        System.out.println("________________________________________________________________________");

        String choice = reader.readLine();

        switch (choice) {
            //cave
            case "n":
                // if player have slain goblin or troll a gained a silver ring in the cave you can't go back there
                // but you can go north to a different Destination
                if (passedPotion > 0) {
                    System.out.println("You go north again\nBut at an another direction");
                    enemyGenerator();
                } else {
                    System.out.println("You choose to go north\n You found a healing potion on the ground");
                    player.currentWeapon.healingPotion++;
                    enemyGenerator();
                }
                break;
            //town
            case "s":
                System.out.println("You choose to go south");
                town();
                break;
            //forest
            case "e":
                System.out.println("You choose to go east");
                break;
            //river
            case "w":
                if (passedPotion == 1) {
                    System.out.println("You can't go west anymore");
                    map();
                } else {
                    System.out.println("You choose to go west");
                    river();
                }


                break;
            //Magic school
            case "magic":
                // If player is a Mage or a Priest you can enter the magic school
                if (mage || priest) {
                    System.out.println("You go to magic school");
                    magicSchool();
                } else {
                    //If player is a Warrior you can't enter magic school
                    System.out.println("Sorry but you are a " + player.currentClass.name);
                    System.out.println("Only classes with magic attributes like (Priest) or (Mage) are welcome to magic school\nYou go back to map");
                    map();
                }
                break;
            default:
                // looks for invalid commands a return to map
                System.out.println("Invalid command try Again");
                map();
                break;


        }
    }

    private void magicSchool() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] magicItems = {shopItems.magicShield, shopItems.pyromancer, shopItems.smite, shopItems.raiseUndead};
        System.out.println("Welcome " + player.currentClass.name);
        System.out.println("What spell do you want to buy?");
        Arrays.sort(magicItems);
        System.out.println(Arrays.toString(magicItems));

        int[] magicPriceItems = {shopItems.magicShieldPrice, shopItems.raiseUndeadPrice, shopItems.pyromancerPrice, shopItems.smitePrice};
        for (int i = 3; i < magicPriceItems.length; i++) {
            int min = magicPriceItems[i];
            for (int j = i + 1; j < magicPriceItems.length; j++) {
                if (magicPriceItems[j] < min) {
                    min = magicPriceItems[j];
                }
            }
            System.out.println("Price in gold order");
            System.out.println(Arrays.toString(magicPriceItems));
            System.out.println("Press(1) Magic shield\nPress(2) Raise undead\nPress(3) Pyromancer spell\nPress(4) Smite spell ");
            int buy = 0;
            try {
                buy = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid command try again");
                magicSchool();
            }
            if (buy == 1) {
                if (player.currentWeapon.unlockMagicShield = false) {
                    System.out.println("You already know that spell");
                    magicSchool();
                } else {
                    System.out.println("You bought " + magicItems[0] + " spell");
                    player.goldCoins = player.goldCoins - 5;
                    player.currentWeapon.unlockMagicShield = true;
                    System.out.println("You have " + player.goldCoins + " gold coins left");
                    map();
                }


            } else if (buy == 2) {
                if (player.currentWeapon.unlockRaiseUndead = false) {
                    System.out.println("You already know that spell");
                    magicSchool();
                } else {
                    System.out.println("You bought " + magicItems[2] + " spell");
                    player.goldCoins = player.goldCoins - 8;
                    player.currentWeapon.unlockRaiseUndead = true;
                    System.out.println("You have " + player.goldCoins + " gold coins left");
                    map();
                }

            } else if (buy == 3) {
                if (player.currentWeapon.unlockPyromancer = false) {
                    System.out.println("You already know that spell");
                    magicSchool();
                } else {
                    System.out.println("You bought " + magicItems[1] + " spell");
                    player.goldCoins = player.goldCoins - 16;
                    player.currentWeapon.unlockRaiseUndead = true;
                    System.out.println("You have " + player.goldCoins + " gold coins left");
                    map();
                }

            } else if (buy == 4) {
                if (player.currentWeapon.unlockPyromancer = false) {
                    System.out.println("You already know that spell");
                    magicSchool();
                } else {
                    System.out.println("You bought " + magicPriceItems[3] + " spell");
                    player.goldCoins = player.goldCoins - 4;
                    player.currentWeapon.unlockRaiseUndead = true;
                    System.out.println("You have " + player.goldCoins + " gold coins  left");
                    map();
                }

            } else if (player.goldCoins < shopItems.magicShieldPrice || player.goldCoins < shopItems.pyromancerPrice || player.goldCoins < shopItems.smitePrice || player.goldCoins < shopItems.raiseUndeadPrice) {
                System.out.println("You don't have enough gold");
                map();
            } else {
                System.out.println("Invalid command try again");
                magicSchool();
            }
        }
    }

    private void river() throws IOException {
        int helmetCost = 5;
        Scanner scan = new Scanner(System.in);
        System.out.println("You drink water from the river you gain 2 more HP is now: " + (player.getHp() + 2));
        System.out.println("Your HP is now:" + (player.getHp() + 2));
        System.out.println("You see an old man approaching you.\nHe tell you that you can buy a helmet from him Press (1) to buy and press (2) to not buy ");
        int choose = scan.nextInt();

        while (warrior) {
            if (choose == 1) {
                System.out.println("It will be 5 gold coins.\nPlease Enter amount of coins:");
                buy = scan.nextInt();
                if (buy == 5)
                    System.out.println("The " + mailHelmet.getName() + " will cost " + helmetCost);
                System.out.println("You buy a " + mailHelmet.getName());
                player.currentArmor = new MailHelmet();
                player.currentArmor.armor = player.currentArmor.armor + 2;
                player.hp = player.hp + player.currentArmor.armor + 2;
                player.goldCoins = player.goldCoins - 5;
                System.out.println("Your HP is now: " + (player.hp + player.currentArmor.getArmor()));
                System.out.println("Bonus HP from " + mailHelmet.getName() + " is " + mailHelmet.getArmor());
                passedPotion++;
                map();
            } else if (buy < 5) {
                System.out.println("You dont have enough cold coins ");
                river();
            } else if (choose == 2) {
                System.out.println("You go back to the cross road");
                map();
            }
        }
        while (!warrior) {
            if (choose == 1) {
                System.out.println("It will be 5 gold coins.\nPlease Enter amount of coins:");
                buy = scan.nextInt();
                if (buy == 5) {
                    System.out.println("The " + clothHelmet.getName() + " will cost " + helmetCost);
                    System.out.println("You buy a " + clothHelmet.getName());
                    player.currentArmor = new MailHelmet();
                    player.currentArmor.armor = player.currentArmor.armor + 2;
                    System.out.println("Your HP is now: " + (player.hp + player.currentArmor.getArmor()));
                    System.out.println("Bonus HP from " + clothHelmet.name + " is " + clothHelmet.getArmor());
                    player.goldCoins = player.goldCoins - 5;
                    passedPotion++;
                    map();
                } else if (buy > clothHelmet.price) {
                    System.out.println("You get " + (buy - shopItems.getPrice()) + " gold coins  back");
                    player.goldCoins = (player.goldCoins - shopItems.getPrice());
                    System.out.println("You bought " + clothHelmet.price + "Your gold is now " + player.getGoldCoins());
                    town();
                } else if (buy < 5) {
                    System.out.println("You dont have enough cold coins ");
                    river();
                }


            } else if (choose == 2) {
                System.out.println("You go back to the cross road");
                map();
            }
        }


    }

    private void town() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You enter the town and see a shop\nIt display a smorgasbord of items. ");
        String[] str = {shopItems.getArmorName(), shopItems.getPotionName(), shopItems.getWeaponName()};
        Arrays.sort(str);
        System.out.println("Press (1).(2).(3). : " + Arrays.toString(str));
        System.out.println("What do you want to buy? Press (4) to go to map");
        int buy = scanner.nextInt();
        while (warrior) {


            if (buy == 1) {
                shopItems.price += 6;
                System.out.println("You buy a " + shopItems.getWeaponName() + "\nit will cost " + shopItems.getPrice() + " gold coins");
                System.out.println("Press the amount you owe " + (shopItems.price) + " Press  (2) to go back");
                buy = scanner.nextInt();
                if (buy == shopItems.price) {
                    player.goldCoins = (player.goldCoins - 6);
                    player.currentWeapon = new WeaponGreatSword();
                    System.out.println("You bought a " + shopItems.getWeaponName() + "Your gold is now " + player.getGoldCoins());
                    System.out.println("The " + shopItems.getWeaponName() + " makes 4 more damage than " + weaponLongSword.getName());
                    town();

                } else if (buy > shopItems.price) {
                    System.out.println("You get " + (buy - shopItems.getPrice()) + " gold coins  back");
                    player.goldCoins = (player.goldCoins - shopItems.getPrice());
                    System.out.println("You bought " + shopItems.getWeaponName() + "Your gold is now " + player.getGoldCoins());
                    town();
                } else if (buy == 2) {
                    town();
                } else if (player.goldCoins < shopItems.price) {
                    System.out.println("Not enough gold coins yet you go back to town");
                    town();
                } else {
                    System.out.println("Invalid command try again");
                    town();
                }


            } else if (buy == 2) {
                shopItems.price += 5;
                System.out.println("You buy a " + shopItems.getArmorName() + "\nit will cost " + shopItems.getPrice() + " gold coins");
                System.out.println("You gain " + shopItems.getArmor() + " armor ");
                System.out.println("Press the amount you owe " + (shopItems.price) + " Press  (2) to go back");
                if (buy == shopItems.price) {
                    player.goldCoins = (player.goldCoins - 5);
                    player.currentWeapon = new WeaponGreatSword();
                    System.out.println("You bought a " + shopItems.getArmorName() + "Your gold is now " + player.getGoldCoins());
                    town();
                } else if (buy > shopItems.price) {
                    System.out.println("You get " + (buy - shopItems.price) + " gold coins  back");
                    player.goldCoins = (player.goldCoins - shopItems.price);
                    System.out.println("You bought " + shopItems.getArmorName() + "Your gold is now " + player.getGoldCoins());
                    town();
                } else {
                    town();
                }

            } else if (buy == 3) {
                int amount = 0;
                shopItems.price += 2;
                System.out.println("You want to buy a " + shopItems.getPotionName() + "\nit will cost " + shopItems.getPrice() + " gold coins");
                System.out.println("How many potions do you want to buy");
                amount = scanner.nextInt();
                System.out.println("You want to buy" + " " + amount + shopItems.getPotionName() + "(s) total cost is " + amount * shopItems.getPrice() + " gold coins ");

                System.out.println("Press the amount you owe " + (shopItems.price * amount) + " Press  (2) to go back");
                buy = scanner.nextInt();
                if (buy == shopItems.price * amount) {
                    player.goldCoins = (player.goldCoins - shopItems.price * amount);
                    System.out.println("You bought  " + amount + shopItems.potionName + "Your gold is now " + player.goldCoins);
                    healingPotion.healingPotion = healingPotion.getHealingPotion() + amount;
                    System.out.println("Total " + shopItems.getPotionName() + " is " + (player.currentWeapon.getHealingPotion() + amount));
                    town();

                } else if (buy > (shopItems.price * amount)) {
                    System.out.println("You get " + (buy - shopItems.price * amount) + " gold coins  back");
                    player.goldCoins = (player.goldCoins - shopItems.price * amount);
                    System.out.println("You bought " + amount + shopItems.getPotionName() + " Your gold is now " + player.getGoldCoins());
                    healingPotion.healingPotion = healingPotion.getHealingPotion() + amount;
                    System.out.println("Total " + shopItems.potionName + " is " + (player.currentWeapon.getHealingPotion() + amount));
                    town();
                } else if (buy == 2) {
                    town();
                } else if (player.goldCoins < shopItems.price) {
                    System.out.println("You don't have enough gold coins yet you return to the town ");
                    town();
                } else {
                    System.out.println("Invalid command try again");
                    town();
                }
            } else if (buy == 4) {
                System.out.println("Return to map");
                map();
            }
        }
    }
}



