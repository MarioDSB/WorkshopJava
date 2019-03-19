package JavaRPG.src.Equipment.Weapons;

import JavaRPG.src.Stats.*;

import java.util.HashMap;
import java.util.Map;

public class BowAndArrow extends Weapon implements WeaponInterface {


    public BowAndArrow() {
        Map<StatType, Double> attributes = new HashMap<>();

        attributes.put(StatType.CRIT_CHANCE, 0.10);
        attributes.put(StatType.DMG, 5.0);

        setModifiers(attributes);
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.BOW_AND_ARROW;
    }
}
