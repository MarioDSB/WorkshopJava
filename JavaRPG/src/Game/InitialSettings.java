package JavaRPG.src.Game;

import JavaRPG.src.Characters.Class.*;
import JavaRPG.src.Characters.Player;
import JavaRPG.src.Equipment.Armor.*;
import JavaRPG.src.Equipment.Weapons.*;

import java.util.Scanner;

class InitialSettings {
    private final Scanner in = new Scanner(System.in);
    private Player player;

    Player startUp() {
        System.out.println("Hello traveller!");
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.println("\nWelcome, " + name + "!");
        System.out.println("\nIn this game, your goal is to survive.");
        System.out.println("Enemies will appear in your way and try to kill you.");
        System.out.println("Good luck!");

        this.setupPlayer(name);

        this.setupEquipment();

        in.close();

        return player;
    }

    private void initPlayer(int option, String name) {
        switch (option) {
            case 1:
                player = new Player(new Assassin(), name);
                break;
            case 2:
                player = new Player(new Footman(), name);
                break;
            case 3:
                player = new Player(new Knight(), name);
                break;
            case 4:
                player = new Player(new Ranger(), name);
                break;
        }
    }

    private void setupPlayer(String name) {
        while (true) {
            System.out.println("\nChoose your class:");
            System.out.println("    1) Assassin (Critical attack and evasion-based class)");
            System.out.println("    2) Footman  (Damage and evasion-based class)");
            System.out.println("    3) Knight   (Damage and defense-based class)");
            System.out.println("    4) Ranger   (Critical attack and damage-based class, with some evasion)");

            try {
                int option = Integer.parseInt(in.nextLine());

                if (option >= 1 && option <= 4) {
                    this.initPlayer(option, name);
                    return;
                }
                else
                    throw new Exception("Input not supported\n");

            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to 4, corresponding to the class you want to play.");
            }
        }
    }

    private void initWeapon(int option) {
        switch (option) {
            case 1:
                player.addEquipment(new BowAndArrow());
                break;
            case 2:
                player.addEquipment(new DoubleKnives());
                break;
            case 3:
                player.addEquipment(new Spear());
                break;
            case 4:
                player.addEquipment(new SwordShield());
                break;
            case 5:
                player.addEquipment(new TwoHandedSword());
                break;
        }
    }

    private void initArmor(int option) {
        switch (option) {
            case 1:
                player.addEquipment(new NoArmor());
                break;
            case 2:
                player.addEquipment(new LightArmor());
                break;
            case 3:
                player.addEquipment(new MediumArmor());
                break;
            case 4:
                player.addEquipment(new HeavyArmor());
                break;
        }
    }

    private void getWeapon() {
        while(true) {
            System.out.println("\nNow choose your weapon:");
            System.out.println("    1) Bow and Arrow        (Critical attack and damage-based weapon)");
            System.out.println("    2) Double Knives        (Critical attack and evasion-based weapon)");
            System.out.println("    3) Spear                (Defense and evasion-based weapon)");
            System.out.println("    4) Sword and Shield     (Damage and defense-based option)");
            System.out.println("    5) Two Handed Sword     (Damage-based weapon)");

            try {
                int option = Integer.parseInt(in.nextLine());

                if (option >= 1 && option <= 5) {
                    this.initWeapon(option);
                    return;
                }
                else
                    throw new Exception("Input not supported\n");
            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to 5, corresponding to the weapon you want to use.");
            }
        }
    }

    private void getArmor() {
        while(true) {
            System.out.println("\nAnd finally, your armor:");
            System.out.println("    1) No Armor         (Increased evasion)");
            System.out.println("    2) Light Armor      (Slightly increased defense and evasion)");
            System.out.println("    3) Medium Armor     (Increased defense)");
            System.out.println("    4) Heavy Armor      (Increased defense and HP, decreased evasion)");

            try {
                int option = Integer.parseInt(in.nextLine());

                if (option >= 1 && option <= 4) {
                    this.initArmor(option);
                    return;
                }
                else
                    throw new Exception("Input not supported\n");
            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to 4, corresponding to the armor you want to wear.");
            }
        }
    }

    private void setupEquipment() {
        this.getWeapon();
        this.getArmor();
    }
}
