package woche07;

public class PlayerCardCollection {
    
    private PlayerCard[] collection;
    private int count, capacity = 100;

    /**
     * 
     */
    public PlayerCardCollection() {
        this.collection = new PlayerCard[this.capacity];
        this.count = 0;
    }

    public void addPlayerCard(String playerName, int cardNumber) {
        if (this.count == this.capacity) {
            this.increaseSize();
        }
        this.collection[count] = new PlayerCard(playerName, cardNumber);
        this.count++;
    }

    public String toString() {
        String collectionAsString = "Anzahl Karten: " + this.count + "\n";
        collectionAsString += "\nMeine Karten:\n";
        for (int i = 0; i < this.count; i++) {
            collectionAsString += this.collection[i] + "\n";
        }
        return collectionAsString;
    }

    private void increaseSize() {
        PlayerCard[] temp = new PlayerCard[this.capacity * 2];
        for (int i = 0; i < this.collection.length; i++) {
            temp[i] = this.collection[i];
        }
        this.collection = temp;
        this.capacity = this.collection.length;
    }
}
