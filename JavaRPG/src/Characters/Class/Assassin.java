package JavaRPG.src.Characters.Class;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class Assassin extends CharacterClass {

    public Assassin() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.33);
        attributes.put(StatType.DMG, 7.0);
        attributes.put(StatType.DEFENSE, 3.0);
        attributes.put(StatType.EVASION, 0.20);
        attributes.put(StatType.HP, 80.0);
        attributes.put(StatType.LUCK, 0.10);

        setAttributes(attributes);
    }

    @Override
    public ClassType getClassType() {
        return ClassType.ASSASSIN;
    }
}
