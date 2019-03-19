package JavaRPG.src.Equipment.Armor;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class LightArmor extends Armor implements ArmorInterface {
    public LightArmor() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.DEFENSE, 3.0);
        attributes.put(StatType.EVASION, 0.05);

        setModifiers(attributes);
    }

    @Override
    public ArmorType getArmorType() {
        return ArmorType.LIGHT;
    }
}
