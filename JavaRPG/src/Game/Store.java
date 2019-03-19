package JavaRPG.src.Game;

import JavaRPG.src.Characters.Player;
import JavaRPG.src.Equipment.Other.HealthPotion;

import java.util.Scanner;

class Store {

    private final Scanner in = new Scanner(System.in);

    boolean showStoreInterface(Player player, boolean purchase) {
        System.out.print("\nWelcome to the store, traveller.");
        if (purchase) {
            System.out.println("\nI'm sorry, but I'm out of stock for today...");
            System.out.println("Maybe you could come back tomorrow.");

            return false;
        }

        int option = 0;
        while (option == 0) {
            System.out.println("\nWhat have you come here for? (You can only buy one thing per turn)");
            System.out.println("    1) Buy and use an health potion");
            System.out.println("    2) Improve weapon damage");
            System.out.println("    3) Improve armor defense");
            System.out.println("    4) Leave the store");

            try {
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        option = this.potionDescription();
                        break;
                    case 2:
                        option = this.weaponDescription();
                        break;
                    case 3:
                        option = this.armorDescription();
                        break;
                    case 4:
                        this.leaveStore();
                        return false;
                }
            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to 4, corresponding to the action you want to take.");
                option = 0;
            }
        }

        this.makePurchase(player, option);
        return true;
    }

    private void makePurchase(Player player, int option) {
        switch (option) {
            case 1:
                player.addEquipment(new HealthPotion());
                break;
            case 2:
                player.improveDmg();
                break;
            case 3:
                player.improveDef();
                break;
        }
    }

    private int potionDescription() {
        while (true) {
            System.out.println("\nBuying a health potion increases your health.");
            System.out.println("Do you want to buy a health potion?");
            System.out.println("1) Yes              2) No");

            int option;
            try {
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        return 1;
                    case 2:
                        return 0;
                    default:
                        throw new Exception("Input not supported\n");
                }
            } catch (Exception ignored) {
                System.out.println("Enter 1, if you want to buy the item, 2 if you don't.");
            }
        }
    }

    private int weaponDescription() {
        while (true) {
            System.out.println("\nAre you sure you want to upgrade your weapon?");
            System.out.println("1) Yes              2) No");

            int option;
            try {
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        return 2;
                    case 2:
                        return 0;
                    default:
                        throw new Exception("Input not supported\n");
                }
            } catch (Exception ignored) {
                System.out.println("Enter 1, if you want to buy the upgrade, 2 if you don't.");
            }
        }
    }

    private int armorDescription() {
        while (true) {
            System.out.println("\nAre you sure you want to upgrade your armor?");
            System.out.println("1) Yes              2) No");

            int option;
            try {
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        return 3;
                    case 2:
                        return 0;
                    default:
                        throw new Exception("Input not supported\n");
                }
            } catch (Exception ignored) {
                System.out.println("Enter 1, if you want to buy the upgrade, 2 if you don't.");
            }
        }
    }

    private void leaveStore() {
        System.out.println("\nThank you, and come back anytime.");
    }
}
