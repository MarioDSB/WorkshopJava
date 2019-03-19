package JavaRPG.src.Equipment;

import JavaRPG.src.Stats.StatType;

import java.util.Map;

public abstract class Equipment {
    public abstract Map<StatType, Double> getModifiers();

    protected abstract void setModifiers(Map<StatType, Double> modifiers);
}
