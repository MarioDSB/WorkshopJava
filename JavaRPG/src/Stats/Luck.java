package JavaRPG.src.Stats;

public class Luck extends Stats {
    private double luckBoost;

    public Luck(double luckBoost) {
        this.luckBoost = luckBoost;
    }

    public StatType getStatType() {
        return StatType.LUCK;
    }

    public double getValue() {
        return this.luckBoost;
    }
}
