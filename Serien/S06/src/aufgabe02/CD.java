package aufgabe02;

public class CD implements IArticle{

    private int id;
	private String title;
	private String interpret;
	private int year;
	private int price; // CHF

    	/** constructor */
	public CD( int id, String title, String interpret, int year, int price )
	{
		this.id = id;
		this.title = title;
		this.interpret = interpret;
		this.year = year;
		this.price = price;
	}

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return id + " (CD) " + title + ", by " + interpret +
            ", " + year + ", " + price + " CHF";
    }
    
}
