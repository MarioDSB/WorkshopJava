package JavaRPG.src.Equipment.Armor;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class HeavyArmor extends Armor implements ArmorInterface {
    public HeavyArmor() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.DEFENSE, 5.0);
        attributes.put(StatType.HP, 20.0);
        attributes.put(StatType.EVASION, -0.05);

        setModifiers(attributes);
    }

    @Override
    public ArmorType getArmorType() {
        return ArmorType.HEAVY;
    }
}
