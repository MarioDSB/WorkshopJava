package JavaRPG.src.Equipment.Weapons;

import JavaRPG.src.Equipment.Equipment;
import JavaRPG.src.Stats.StatType;

import java.util.Map;

public class Weapon extends Equipment {
    private Map<StatType, Double> modifiers;

    Weapon() {}

    @Override
    public Map<StatType, Double> getModifiers() {
        return this.modifiers;
    }

    protected void setModifiers(Map<StatType, Double> modifiers) {
        this.modifiers = modifiers;
    }
}
