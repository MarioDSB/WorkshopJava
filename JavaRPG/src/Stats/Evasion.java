package JavaRPG.src.Stats;

public class Evasion extends Stats {
    private double evasionBoost;

    public Evasion(double evasionBoost) {
        this.evasionBoost = evasionBoost;
    }

    public StatType getStatType() {
        return StatType.EVASION;
    }

    public double getValue() {
        return this.evasionBoost;
    }
}
