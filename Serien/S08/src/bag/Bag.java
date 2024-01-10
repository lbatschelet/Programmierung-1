package bag;

public class Bag {

    private int value;
    private Bag innerBag;

    public Bag() {
        this.innerBag = null;
    }

    public Bag(int value) {
        this.value = value;
        this.innerBag = new Bag();
    }

    public void addValue(int value) {
        if (this.innerBag == null) {
            this.value = value;
            this.innerBag = new Bag();
        } else {
            this.innerBag.addValue(value);
        }
    }

    public String toString() {
        if (this.innerBag == null) {
            return "EMPTY";
        } else {
            return "(" + this.value + ", " + this.innerBag + ")";
        }
    }
}
