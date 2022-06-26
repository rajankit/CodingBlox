package pointsStrategy;

public class CalculatePointForForHighContest implements PointCalculate {
    private int points;

    public CalculatePointForForHighContest(int points) {
        this.points = points;
    }

    @Override
    public int calculateScore() {
        return this.points;
    }
}
