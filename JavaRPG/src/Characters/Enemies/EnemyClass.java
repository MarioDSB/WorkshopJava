package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.StatType;

import java.util.Map;

public abstract class EnemyClass {
    private Map<StatType, Double> attributes;

    EnemyClass() {}

    EnemyClass(Map<StatType, Double> attributes) {
        this.attributes = attributes;
    }

    public Map<StatType, Double> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Map<StatType, Double> attributes) {
        this.attributes = attributes;
    }

    public abstract EnemyType getClassType();

    public abstract String getEnemyName();

    public void attacked(double dmg) {
        attributes.replace(StatType.HP, attributes.get(StatType.HP) - dmg);
    }

    public Double getAttribute(StatType attribute) {
        return this.attributes.get(attribute);
    }

    public String getStatus() {
        return " (" + attributes.get(StatType.HP) + " HP)";
    }
}
