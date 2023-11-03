package woche07;

public class Team {

    private String teamName;
    private int currentPoints;

    /**
    * instanziiert ein neues Team
    */
    public Team(String teamName) {
        this.teamName = teamName;
        this.currentPoints = 0;
    }

    /**
    * Zeichenkettenreprasentation dieses Teams
    */
    public String toString() {
        return this.teamName + ": " + this.currentPoints + " Punkte";
    }

    /**
    * fugt diesem Team Punkte hinzu
    */
    public void addPoints(int points) {
        this.currentPoints += points;
    }
}