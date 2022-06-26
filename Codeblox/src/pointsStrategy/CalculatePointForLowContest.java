package pointsStrategy;

public class CalculatePointForLowContest implements PointCalculate {
    private int points;

    public CalculatePointForLowContest(int points) {
        this.points = points;
    }

    @Override
    public int calculateScore() {
        return this.points - 50;
    }
}
