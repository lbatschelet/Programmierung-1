package woche07;

public class PlayerCard {

    // Instanzvariablen für PlayerCard Objekte
    private String playerName;
    private int cardNumber;

    /**
    * Konstruktor für PlayerCard Objekte
    */
    public PlayerCard(String playerName, int cardNumber) {
                                                          this.playerName = playerName;
                                                          this.cardNumber = cardNumber;
    }

    /**
    * Zeichenkettenrepräsentation für PlayerCard Objekte
    */
    public String toString() {
        return this.playerName + ", " + this.cardNumber;
    }
}