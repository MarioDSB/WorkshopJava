package JavaRPG.src.Characters.Class;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class Ranger extends CharacterClass {

    public Ranger() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.20);
        attributes.put(StatType.DMG, 10.0);
        attributes.put(StatType.DEFENSE, 3.0);
        attributes.put(StatType.EVASION, 0.33);
        attributes.put(StatType.HP, 60.0);
        attributes.put(StatType.LUCK, 0.15);

        setAttributes(attributes);
    }

    @Override
    public ClassType getClassType() {
        return ClassType.RANGER;
    }
}
