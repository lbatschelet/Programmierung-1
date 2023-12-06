package woche11;

public class Item<T> {

    private T value; // Das zu verwaltende Objekt
    private Item<T> below; // Referenz auf das nächste Item

    public Item(T value) {
        this.value = value;
        this.below = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Item<T> getBelow() {
        return below;
    }

    public void setBelow(Item<T> below) {
        this.below = below;
    }
}
