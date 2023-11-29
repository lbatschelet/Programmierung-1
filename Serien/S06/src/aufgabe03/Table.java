package aufgabe03;

public class Table extends Furniture{

    private double area;

    public Table(Material material, double pricePerHour, double workedHours, double area) {
        super(material, pricePerHour, workedHours);
        this.area = area;
    }

    public double totalPrice() {
        return this.calculateEffort() + this.area * this.material.getMaterialCost();
    }
    
}
