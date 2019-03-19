package JavaRPG.src.Stats;

public class HP extends Stats{
    private double HPBoost;

    public HP(double HPBoost) {
        this.HPBoost = HPBoost;
    }

    public StatType getStatType() {
        return StatType.HP;
    }

    public double getValue() {
        return this.HPBoost;
    }
}
