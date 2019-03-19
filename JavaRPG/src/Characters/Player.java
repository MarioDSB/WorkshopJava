package JavaRPG.src.Characters;

import JavaRPG.src.Characters.Class.CharacterClass;
import JavaRPG.src.Equipment.Equipment;
import JavaRPG.src.Stats.*;

import java.util.Map;

public class Player {

    private CharacterClass playerCharacterClass;
    private Map<StatType, Double> baseAttributes;
    private String name;

    /**
     * Usage: new Player(new Assassin/Knight/Footman/Ranger())
     *
     * @param playerCharacterClass The player's class
     */
    public Player(CharacterClass playerCharacterClass, String name) {
        this.playerCharacterClass = playerCharacterClass;
        this.baseAttributes = this.getAttributes();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Map<StatType, Double> getAttributes() {
        return this.playerCharacterClass.getAttributes();
    }

    public Double getAttribute(StatType attribute) {
        return getAttributes().get(attribute);
    }

    public void setAttributes(Map<StatType, Double> attributes) {
        this.playerCharacterClass.setAttributes(attributes);
    }

    public void improveDmg() {
        Map<StatType, Double> attributes = this.getAttributes();

        double currentDmgValue = attributes.get(StatType.DMG);
        attributes.replace(StatType.DMG, currentDmgValue + 2);
        this.setAttributes(attributes);
    }

    public void improveDef() {
        Map<StatType, Double> attributes = this.getAttributes();

        double currentDefValue = attributes.get(StatType.DEFENSE);
        attributes.replace(StatType.DEFENSE, currentDefValue + 2);
        this.setAttributes(attributes);
    }

    public void attacked(double dmg) {
        Map<StatType, Double> attributes = this.getAttributes();
        attributes.replace(StatType.HP, attributes.get(StatType.HP) - dmg);

        this.setAttributes(attributes);
    }

    /**
     * @param equipment The equipment to improve the stats
     */
    public void addEquipment(Equipment equipment) {
        for (Map.Entry<StatType, Double> entry : equipment.getModifiers().entrySet()) {
            StatType key = entry.getKey();

            double attributeValue = this.baseAttributes.get(key);
            switch (key) {
                case CRIT_CHANCE:
                    this.baseAttributes.replace(key, attributeValue + entry.getValue());
                    break;
                case DMG:
                    this.baseAttributes.replace(key, attributeValue + entry.getValue());
                    break;
                case DEFENSE:
                    this.baseAttributes.replace(key, attributeValue + entry.getValue());
                    break;
                case EVASION:
                    this.baseAttributes.replace(key, attributeValue + entry.getValue());
                    break;
                case HP:
                    this.baseAttributes.replace(key, attributeValue + entry.getValue());
                    break;
                case LUCK:
                    this.baseAttributes.replace(key, attributeValue + entry.getValue());
                    break;
            }
        }
    }

    public boolean checkDead() {
        return this.getAttribute(StatType.HP) <= 0;
    }

    public void printStats() {
        Map<StatType, Double> attributes = this.getAttributes();

        System.out.println();
        for (Map.Entry<StatType, Double> entry : attributes.entrySet()) {
            switch (entry.getKey()) {
                case CRIT_CHANCE:
                    System.out.print("Critical chance: ");
                    break;
                case DEFENSE:
                    System.out.print("Defense: ");
                    break;
                case DMG:
                    System.out.print("Damage: ");
                    break;
                case EVASION:
                    System.out.print("Evasion: ");
                    break;
                case HP:
                    System.out.print("HP: ");
                    break;
                case LUCK:
                    System.out.print("Luck: ");
                    break;
            }

            System.out.printf("%.2f\n", entry.getValue());
        }
    }
}
