package JavaRPG.src.Equipment.Weapons;

import JavaRPG.src.Stats.StatType;

import java.util.HashMap;
import java.util.Map;

public class Spear extends Weapon implements WeaponInterface {
    public Spear() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.DEFENSE, 5.0);
        attributes.put(StatType.EVASION, 0.10);

        setModifiers(attributes);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.SPEAR;
    }
}
