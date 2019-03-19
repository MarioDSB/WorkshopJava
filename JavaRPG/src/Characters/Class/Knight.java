package JavaRPG.src.Characters.Class;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class Knight extends CharacterClass {

    public Knight() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.05);
        attributes.put(StatType.DMG, 10.0);
        attributes.put(StatType.DEFENSE, 10.0);
        attributes.put(StatType.EVASION, 0.05);
        attributes.put(StatType.HP, 120.0);
        attributes.put(StatType.LUCK, 0.0);

        setAttributes(attributes);
    }

    @Override
    public ClassType getClassType() {
        return ClassType.KNIGHT;
    }
}
