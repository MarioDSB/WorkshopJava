package JavaRPG.src.Characters.Class;

import JavaRPG.src.Stats.StatType;

import java.util.Map;

public abstract class CharacterClass {
    private Map<StatType, Double> attributes;

    CharacterClass() {}

    public Map<StatType, Double> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<StatType, Double> attributes) {
        this.attributes = attributes;
    }

    public abstract ClassType getClassType();
}
