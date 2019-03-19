package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class GoblinKing extends EnemyClass {

    public GoblinKing() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.10);
        attributes.put(StatType.DMG, 10.0);
        attributes.put(StatType.DEFENSE, 10.0);
        attributes.put(StatType.EVASION, 0.10);
        attributes.put(StatType.HP, 120.0);
        attributes.put(StatType.LUCK, 0.0);

        setAttributes(attributes);
    }

    @Override
    public EnemyType getClassType() {
        return EnemyType.GOBLIN_KING;
    }

    @Override
    public String getEnemyName() {
        return "Goblin King";
    }
}
