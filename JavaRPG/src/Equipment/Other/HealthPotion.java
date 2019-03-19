package JavaRPG.src.Equipment.Other;

import JavaRPG.src.Equipment.Equipment;
import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class HealthPotion extends Equipment {
    private Map<StatType, Double> modifiers;

    public HealthPotion() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.HP, 20.0);

        setModifiers(attributes);
    }

    @Override
    public Map<StatType, Double> getModifiers() {
        return this.modifiers;
    }

    @Override
    protected void setModifiers(Map<StatType, Double> modifiers) {
        this.modifiers = modifiers;
    }
}
