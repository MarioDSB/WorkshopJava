package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class GoblinArcher extends EnemyClass {

    public GoblinArcher() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.15);
        attributes.put(StatType.DMG, 4.0);
        attributes.put(StatType.DEFENSE, 0.0);
        attributes.put(StatType.EVASION, 0.15);
        attributes.put(StatType.HP, 30.0);
        attributes.put(StatType.LUCK, 0.1);

        setAttributes(attributes);
    }

    @Override
    public EnemyType getClassType() {
        return EnemyType.GOBLIN_ARCHER;
    }

    @Override
    public String getEnemyName() {
        return "Goblin Archer";
    }
}
