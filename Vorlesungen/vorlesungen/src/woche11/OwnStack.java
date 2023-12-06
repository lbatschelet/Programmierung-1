package woche11;

public class OwnStack<T> {

    private Item<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Item<T> item = new Item<T>(value);
        item.setBelow(top);
        this.top = item;
    }

    public T pop() {
        T temp = null;
        if (!this.isEmpty()) {
            temp = this.top.getValue();
            this.top = this.top.getBelow();
        }
        return temp;
    }

    public T peek() {
        return !this.isEmpty() ? this.top.getValue() : null;
    }

}
