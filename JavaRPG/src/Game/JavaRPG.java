package JavaRPG.src.Game;

import JavaRPG.src.Characters.Player;

import java.util.Scanner;

public class JavaRPG {
    private final static Scanner in = new Scanner(System.in);
    private static int fights = 0;

    private static void showMainInterface(Player player) {
        boolean purchase = false;

        while (true) {
            System.out.println("\n\nPlayer's name:    " + player.getName());
            System.out.println("Fights won:    " + fights);
            System.out.println("\n1) Play an encounter");
            System.out.println("2) Open the store");
            System.out.println("3) Show stats");
            System.out.println("4) End the game");

            try {
                int option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        Boolean result = new Encounter().randomEncounter(player);
                        if (result == null) {
                            System.out.println("You ran, and so, you won't be able to purchase anything.");
                            break;
                        }

                        if (!result)
                            return;

                        fights++;
                        purchase = false;
                        break;
                    case 2:
                        purchase = new Store().showStoreInterface(player, purchase);
                        break;
                    case 3:
                        player.printStats();
                        break;
                    case 4:
                        if (leaveGame())
                            return;
                        break;
                    default:
                        throw new Exception("Input not supported\n");
                }
            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to 4, corresponding to the action you want to take.");
            }
        }
    }

    private static boolean leaveGame() {
        System.out.println("\nAre you sure you want to leave the game?");
        System.out.println("(Your results aren't saved)");
        System.out.println("1) Yes              2) No");

        while (true) {
            try {
                int option = Integer.parseInt(in.nextLine());
                switch (option) {
                    case 1:
                        System.out.println("\nHope you come back!");
                        return true;
                    case 2:
                        return false;
                }
            } catch (Exception ignored) {
                System.out.println("Enter 1, if you want to play the class, 2 if you don't.");
            }
        }
    }

    public static void main(String[] args) {
        Player player;
        player = new InitialSettings().startUp();

        showMainInterface(player);
    }
}
