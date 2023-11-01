package aufgabe02_03;

public class Player {

    private int pointsThisRound;
    private int pointsTotal;
    private String name;

    public Player(String name) {
        this.pointsThisRound = 0;
        this.pointsTotal = 0;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getPointsThisRound() {
        return this.pointsThisRound;
    }

    public int getPointsTotal() {
        return this.pointsTotal;
    }

    public void setPointsThisRound(int points) {
        this.pointsThisRound = points;
    }

    public void setPointsTotal(int points) {
        this.pointsTotal = points;
    }

    public void addPointsThisRound(int points) {
        this.pointsThisRound += points;
    }

    public void removePointsThisRound() {
        this.pointsThisRound = 0;
    }

    public void addPointsTotal(int points) {
        this.pointsTotal += points;
    }

    public void removePointsTotal() {
        this.pointsTotal = 0;
    }

    public String toString() {
        return this.name + " has " + this.pointsTotal + " points.";
    }


}
