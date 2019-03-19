package JavaRPG.src.Equipment.Armor;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class MediumArmor extends Armor implements ArmorInterface {
    public MediumArmor() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.DEFENSE, 5.0);

        setModifiers(attributes);
    }

    @Override
    public ArmorType getArmorType() {
        return ArmorType.MEDIUM;
    }
}
