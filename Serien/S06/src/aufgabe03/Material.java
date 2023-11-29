package aufgabe03;

public enum Material {
    
    Eiche(100.0),
    Buche(80.0),
    Esche(60.0);

    // price per m^2
    private final double materialCost;

    Material(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getMaterialCost() {
        return materialCost;
    }
}

