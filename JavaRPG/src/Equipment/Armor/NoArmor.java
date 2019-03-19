package JavaRPG.src.Equipment.Armor;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class NoArmor extends Armor implements ArmorInterface {
    public NoArmor() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.EVASION, 0.10);

        setModifiers(attributes);
    }

    @Override
    public ArmorType getArmorType() {
        return ArmorType.NONE;
    }
}
