package woche07;

public class MenuCard {
    
    private final int MAX_MENUS = 3;
    private Menu[] menus;
    private int counter;

    public MenuCard() {
        this.counter = 0;
        this.menus = new Menu[this.MAX_MENUS];
    }

    public void addMenu() {
        this.menus[this.counter % this.MAX_MENUS] = new Menu();
        this.counter++;
    }

    public void printCard() {
        System.out.println("*** LE MENU DU SOIR ***");
        for (Menu m : this.menus)
            if (m != null)
                System.out.println(m);
    }
}
