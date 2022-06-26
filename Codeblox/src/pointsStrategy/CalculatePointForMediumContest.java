package pointsStrategy;

public class CalculatePointForMediumContest implements PointCalculate {
    private int points;

    public CalculatePointForMediumContest(int points) {
        this.points = points;
    }

    @Override
    public int calculateScore() {
        return this.points - 30;
    }
}
