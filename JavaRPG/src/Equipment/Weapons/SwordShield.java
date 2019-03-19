package JavaRPG.src.Equipment.Weapons;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class SwordShield extends Weapon implements WeaponInterface {
    public SwordShield() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.DEFENSE, 5.0);
        attributes.put(StatType.DMG, 5.0);

        setModifiers(attributes);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.SWORD_SHIELD;
    }
}
