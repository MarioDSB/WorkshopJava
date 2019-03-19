package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class CommonGoblin extends EnemyClass {

    public CommonGoblin() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.10);
        attributes.put(StatType.DMG, 4.0);
        attributes.put(StatType.DEFENSE, 2.0);
        attributes.put(StatType.EVASION, 0.10);
        attributes.put(StatType.HP, 30.0);
        attributes.put(StatType.LUCK, 0.05);

        setAttributes(attributes);
    }

    @Override
    public EnemyType getClassType() {
        return EnemyType.COMMON_GOBLIN;
    }

    @Override
    public String getEnemyName() {
        return "Common Goblin";
    }
}
