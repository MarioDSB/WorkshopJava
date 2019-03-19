package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class GoblinSoldier extends EnemyClass {

    public GoblinSoldier() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.05);
        attributes.put(StatType.DMG, 5.0);
        attributes.put(StatType.DEFENSE, 5.0);
        attributes.put(StatType.EVASION, 0.05);
        attributes.put(StatType.HP, 40.0);
        attributes.put(StatType.LUCK, 0.0);

        setAttributes(attributes);
    }

    @Override
    public EnemyType getClassType() {
        return EnemyType.GOBLIN_SOLDIER;
    }

    @Override
    public String getEnemyName() {
        return "Goblin Soldier";
    }
}
