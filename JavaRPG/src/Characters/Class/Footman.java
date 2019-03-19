package JavaRPG.src.Characters.Class;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class Footman extends CharacterClass {

    public Footman() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.10);
        attributes.put(StatType.DMG, 10.0);
        attributes.put(StatType.DEFENSE, 5.0);
        attributes.put(StatType.EVASION, 0.10);
        attributes.put(StatType.HP, 100.0);
        attributes.put(StatType.LUCK, 0.05);

        setAttributes(attributes);
    }

    @Override
    public ClassType getClassType() {
        return ClassType.FOOTMAN;
    }
}
