package JavaRPG.src.Equipment.Weapons;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class DoubleKnives extends Weapon implements WeaponInterface {

    public DoubleKnives() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.10);
        attributes.put(StatType.EVASION, 0.10);

        setModifiers(attributes);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.DOUBLE_KNIVES;
    }
}
