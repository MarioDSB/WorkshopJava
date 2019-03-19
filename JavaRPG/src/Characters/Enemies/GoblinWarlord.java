package JavaRPG.src.Characters.Enemies;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class GoblinWarlord extends EnemyClass {

    public GoblinWarlord() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.0);
        attributes.put(StatType.DMG, 10.0);
        attributes.put(StatType.DEFENSE, 7.0);
        attributes.put(StatType.EVASION, 0.0);
        attributes.put(StatType.HP, 80.0);
        attributes.put(StatType.LUCK, 0.0);

        setAttributes(attributes);
    }

    @Override
    public EnemyType getClassType() {
        return EnemyType.GOBLIN_WARLORD;
    }

    @Override
    public String getEnemyName() {
        return "Goblin Warlord";
    }
}
