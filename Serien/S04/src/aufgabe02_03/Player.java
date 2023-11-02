package aufgabe02_03;

public class Player {

    private int pointsThisRound;
    private int pointsTotal;
    private String name;
    private boolean isComputer;

    public Player(String name) {
        this.pointsThisRound = 0;
        this.pointsTotal = 0;
        this.name = name;
        this.isComputer = false;
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

    public boolean isComputer() {
        return this.isComputer;
    }

    public void setComputer(boolean isComputer) {
        this.isComputer = isComputer;
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

    public boolean rollTheDice(PairOfDice pairOfDice) {
        pairOfDice.rollThePair();
        System.out.println("Dice 1: " + pairOfDice.getDice1());
        System.out.println("Dice 2: " + pairOfDice.getDice2());
        
        if (pairOfDice.isDouble1()) {
            System.out.println(this.name + " lost all points");
            this.removePointsTotal();
            this.removePointsThisRound();
            return true; // turnOver = true
        } else if (pairOfDice.isSingle1()) {
            System.out.println(this.name + " lost " + this.pointsThisRound + " points");
            this.removePointsThisRound();
            return true; // turnOver = true
        } else {
            this.addPointsThisRound(pairOfDice.getSum());
            System.out.println(this.name + " has " + this.pointsThisRound + " points on the line");
            return false; // turnOver = false
        }
    }

    public void endTurn(PigGame game) {
        this.addPointsTotal(this.pointsThisRound);
        this.removePointsThisRound();
        game.changePlayerToPlay();
    }

    public boolean hasWon(int pointsToWin) {
        return this.pointsTotal >= pointsToWin;
    }


}
