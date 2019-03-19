package JavaRPG.src.Game;

import JavaRPG.src.Characters.Enemies.*;
import JavaRPG.src.Characters.Player;
import JavaRPG.src.Stats.StatType;

import java.util.LinkedList;
import java.util.Scanner;

class Encounter {
    private final Scanner in = new Scanner(System.in);
    private LinkedList<EnemyClass> enemies = new LinkedList<>();

    private int getNumberEnemies() {
        double random = Math.random();

        /*
         * 1 enemy chance: 40%
         * 2 enemies chance: 35%
         * 3 enemies chance: 25%
         */
        if (random < 0.4)
            return 1;
        else if (random <= 0.75)
            return 2;
        else return 3;
    }

    private EnemyClass generateEnemy() {
        double random = Math.random();

        /*
         * Wolf chance p/enemy: 20%
         * Common Goblin chance p/enemy: 20%
         * Goblin Archer chance p/enemy: 15%
         * Goblin Skulker chance p/enemy: 15%
         * Goblin Soldier chance p/enemy: 15%
         * Goblin Warlord chance p/enemy: 10%
         * Goblin King chance p/enemy: 5%
         */
        if (random < 0.2)
            return new Wolf();
        else if (random <= 0.4)
            return new CommonGoblin();
        else if (random <= 0.55)
            return new GoblinArcher();
        else if (random <= 0.7)
            return new GoblinSkulker();
        else if (random <= 0.85)
            return new GoblinSoldier();
        else if (random <= 0.95)
            return new GoblinWarlord();
        else return new GoblinKing();
    }

    private void generateEnemyList() {
        int numEnemies = this.getNumberEnemies();

        for (int i = 0; i < numEnemies; i++) {
            EnemyClass enemy = this.generateEnemy();
            this.enemies.addFirst(enemy);
        }
    }

    /**
     * @param player The player
     */
    private Boolean battle(Player player) {
        boolean battleEnd = false, checkDead = false;

        while (!battleEnd) {
            if (checkDead) {
                System.out.println("\nYou died... Game Over...");
                return false;
            }

            System.out.println("\nYou have " + player.getAttribute(StatType.HP) + " HP.");

            System.out.println("Enemies:");
            for (EnemyClass enemy : enemies)
                System.out.println("    " + (enemies.indexOf(enemy) + 1) + ") " +
                        enemy.getEnemyName() + enemy.getStatus());


            System.out.println("\nWhat do you want to do?");
            System.out.println("    1) Attack");
            System.out.println("    2) Defend");
            System.out.println("    3) Run away");

            int option;
            try {
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        if (enemies.size() == 1) {
                            player = this.attack(player, 1);
                            checkDead = player.checkDead();
                            battleEnd = this.checkDeadEnemies();
                        }
                        else {
                            int attackOption = this.attackOption();

                            if (attackOption != 0) {
                                player = this.attack(player, attackOption);
                                checkDead = player.checkDead();
                                battleEnd = this.checkDeadEnemies();
                            }
                        }

                        break;
                    case 2:
                        player = this.defend(player);
                        checkDead = player.checkDead();
                        battleEnd = this.checkDeadEnemies();
                        break;
                    case 3:
                        if(this.runAway())
                            return null;
                        break;
                    default:
                        throw new Exception("Input not supported\n");
                }
            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to 3, corresponding to the action you want to take.");
            }
        }

        System.out.println("You win!");
        return true;
    }

    private double genRandom() {
        return Math.random();
    }

    private boolean checkDeadEnemies() {
        LinkedList<EnemyClass> toRemove = new LinkedList<>();

        for (EnemyClass enemy : enemies) {
            if (enemy.getAttribute(StatType.HP) <= 0) {
                System.out.println("\n" + enemy.getEnemyName() + " has died.");

                toRemove.add(enemy);
            }
        }

        enemies.removeAll(toRemove);

        return enemies.isEmpty();
    }

    private String showDmg(double dmg) {
        return " (" + dmg + " dmg)";
    }

    private boolean statCheck(double stat) {
        return stat > genRandom();
    }

    private Player attack(Player player, int attackOption) {
        double dmg;

        if (statCheck(player.getAttribute(StatType.CRIT_CHANCE))) {
            dmg = player.getAttribute(StatType.DMG) * 2 - enemies.get(attackOption - 1).getAttribute(StatType.DEFENSE);

            System.out.println("\nYou did critical damage!" + this.showDmg(dmg));
            enemies.get(attackOption - 1).attacked(dmg);
        } else {
            dmg = player.getAttribute(StatType.DMG) - enemies.get(attackOption - 1).getAttribute(StatType.DEFENSE);

            System.out.println("\nYou attacked." + this.showDmg(dmg));
            enemies.get(attackOption - 1).attacked(dmg);
        }

        if(checkDeadEnemies()) {
            return player;
        }

        for (EnemyClass enemy : enemies) {
            if (statCheck(enemy.getAttribute(StatType.CRIT_CHANCE))) {
                if (statCheck(player.getAttribute(StatType.LUCK))) {
                    double attack = enemy.getAttribute(StatType.DMG) - player.getAttribute(StatType.DEFENSE);
                    if (attack < 0)
                        attack = 0;

                    System.out.println(enemy.getEnemyName() + " critically attacks you, but, luckily, " +
                            "the attacked missed any vital spots." + this.showDmg(attack));

                    if (attack == 0)
                        continue;

                    player.attacked(attack);
                } else {
                    double attack = enemy.getAttribute(StatType.DMG) * 2 - player.getAttribute(StatType.DEFENSE);
                    if (attack < 0)
                        attack = 0;

                    System.out.println("You are critically attacked by a " + enemy.getEnemyName() + "." +
                            this.showDmg(attack));

                    if (attack == 0)
                        continue;

                    player.attacked(attack);
                }
            } else {
                if (statCheck(player.getAttribute(StatType.EVASION))) {
                    System.out.println("You are attacked by a " + enemy.getEnemyName() + ", " +
                            " but you evade the attack." + this.showDmg(0));
                } else {
                    double attack = enemy.getAttribute(StatType.DMG) - player.getAttribute(StatType.DEFENSE);
                    if (attack < 0)
                        attack = 0;

                    System.out.println("You are attacked by a " + enemy.getEnemyName() + "." +
                            this.showDmg(attack));

                    if (attack == 0)
                        continue;

                    player.attacked(attack);
                }
            }
        }

        return player;
    }

    private Player defend(Player player) {
        double attack;

        System.out.println();
        for (EnemyClass enemy : enemies) {
            if (statCheck(player.getAttribute(StatType.EVASION))) {
                if (statCheck(player.getAttribute(StatType.LUCK) + 0.1)) {
                    if (statCheck(player.getAttribute(StatType.CRIT_CHANCE))) {
                        attack = player.getAttribute(StatType.DMG) * 2 - enemy.getAttribute(StatType.DEFENSE);

                        System.out.println("You managed to evade a " + enemy.getEnemyName() +
                                "'s attack, and, countered, dealing critical damage." + this.showDmg(attack));

                        enemy.attacked(attack);
                    } else {
                        attack = player.getAttribute(StatType.DMG) - enemy.getAttribute(StatType.DEFENSE);

                        System.out.println("You managed to evade a " + enemy.getEnemyName() +
                                "'s attack, and countered, dealing damage." + this.showDmg(attack));

                        enemy.attacked(attack);
                    }
                } else {
                    System.out.println("You managed to evade a " + enemy.getEnemyName() +
                            "'s attack." + this.showDmg(0));
                }
            } else {
                if (statCheck(enemy.getAttribute(StatType.CRIT_CHANCE))) {
                    if (statCheck(player.getAttribute(StatType.LUCK))) {
                        attack = enemy.getAttribute(StatType.DMG) - player.getAttribute(StatType.DEFENSE);
                        if (attack < 0)
                            attack = 0;

                        System.out.println(enemy.getEnemyName() + " manages to breach your defenses, but, luckily, " +
                                "the attacked missed any vital spots." + this.showDmg(attack));

                        if (attack == 0)
                            continue;

                        player.attacked(attack);
                    } else {
                        attack = enemy.getAttribute(StatType.DMG) * 2 - player.getAttribute(StatType.DEFENSE);
                        if (attack < 0)
                            attack = 0;

                        System.out.println(enemy.getEnemyName() + " manages to breach your defenses," +
                                "and deals critical damage." + this.showDmg(attack));

                        if (attack == 0)
                            continue;

                        player.attacked(attack);
                    }
                } else {
                    if (statCheck(player.getAttribute(StatType.LUCK))) {
                        System.out.println(enemy.getEnemyName() + " attacks you, but, luckily, " +
                                "you dodged it." + this.showDmg(0));
                    } else {
                        attack = enemy.getAttribute(StatType.DMG) - player.getAttribute(StatType.DEFENSE);
                        if (attack < 0)
                            attack = 0;

                        System.out.println(enemy.getEnemyName() + " attacks you." + this.showDmg(attack));

                        if (attack == 0)
                            continue;

                        player.attacked(attack);
                    }
                }
            }
        }

        return player;
    }

    private int attackOption() {
        int option;
        while(true) {
            System.out.println("\nWho do you want to attack");

            for (EnemyClass enemy : enemies)
                System.out.println("    " + (enemies.indexOf(enemy) + 1) + ") " + enemy.getEnemyName());
            System.out.println("    " + (enemies.size() + 1) + ") Go back");

            try {
                option = Integer.parseInt(in.nextLine());

                if (option == enemies.size() + 1)
                    return 0;
                else if (option > enemies.size() + 1 || option < 1)
                    throw new Exception("Input not supported\n");

                return option;
            } catch (Exception ignored) {
                System.out.println("Enter a number from 1 to " + (enemies.size() + 1) +
                        ", corresponding to the action you want to take.");
            }
        }
    }

    private boolean runAway() {
        while (true) {
            System.out.println("\nAre you sure you want to run away?");
            System.out.println("(You won't recover your health)");
            System.out.println("1) Yes              2) No");

            int option;
            try {
                option = Integer.parseInt(in.nextLine());

                switch (option) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                        throw new Exception("Input not supported\n");
                }
            } catch (Exception ignored) {
                System.out.println("Enter 1, if you want to buy the item, 2 if you don't.");
            }
        }
    }

    Boolean randomEncounter(Player player) {
        this.generateEnemyList();

        return battle(player);
    }
}
