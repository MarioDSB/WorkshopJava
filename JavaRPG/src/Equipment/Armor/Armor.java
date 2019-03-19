package JavaRPG.src.Equipment.Armor;

import JavaRPG.src.Equipment.Equipment;
import JavaRPG.src.Stats.StatType;

import java.util.Map;

public class Armor extends Equipment {
    private Map<StatType, Double> modifiers;

    Armor() {}

    @Override
    public Map<StatType, Double> getModifiers() {
        return this.modifiers;
    }

    protected void setModifiers(Map<StatType, Double> modifiers) {
        this.modifiers = modifiers;
    }
}
