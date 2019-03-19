package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends EnemyClass {

    public Wolf() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.10);
        attributes.put(StatType.DMG, 4.0);
        attributes.put(StatType.DEFENSE, 0.0);
        attributes.put(StatType.EVASION, 0.10);
        attributes.put(StatType.HP, 20.0);
        attributes.put(StatType.LUCK, 0.0);

        setAttributes(attributes);
    }

    @Override
    public EnemyType getClassType() {
        return EnemyType.WOLF;
    }

    @Override
    public String getEnemyName() {
        return "Wolf";
    }
}
