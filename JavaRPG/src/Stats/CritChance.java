package JavaRPG.src.Stats;

public class CritChance extends Stats {
    private double critChance;

    public CritChance(double critChance) {
        this.critChance = critChance;
    }

    public StatType getStatType() {
        return StatType.CRIT_CHANCE;
    }

    public double getValue() {
        return this.critChance;
    }
}
