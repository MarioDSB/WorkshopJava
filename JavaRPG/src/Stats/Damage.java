package JavaRPG.src.Stats;

public class Damage extends Stats {
    private double DMGBoost;

    public Damage(double DMGBoost) {
        this.DMGBoost = DMGBoost;
    }

    public StatType getStatType() {
        return StatType.DMG;
    }

    public double getValue() {
        return this.DMGBoost;
    }
}
