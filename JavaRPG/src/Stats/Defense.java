package JavaRPG.src.Stats;

public class Defense extends Stats {
    private double DEFBoost;

    public Defense(double DEFBoost) {
        this.DEFBoost = DEFBoost;
    }

    public StatType getStatType() {
        return StatType.DEFENSE;
    }

    public double getValue() {
        return this.DEFBoost;
    }
}
