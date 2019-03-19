package JavaRPG.src.Equipment.Weapons;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class TwoHandedSword extends Weapon implements WeaponInterface {
    public TwoHandedSword() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.DMG, 10.0);

        setModifiers(attributes);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.TWO_HANDED_SWORD;
    }
}
