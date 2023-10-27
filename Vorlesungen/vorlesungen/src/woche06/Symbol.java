package woche06;

public class Symbol {

	private String name;

	public Symbol(String name) {
		this.name = name;
	}

	public String toString() {
		return this.name;
	}

	public int compareTo(Symbol other) {
		if (this.name.equals(other.name))
			return 0;
		else
			switch(this.name) {
			case "Schere" :
				if (other.name.equals("Stein"))
					return -1;
				else
					return 1; // other = Papier
			case "Stein" :
				if (other.name.equals("Schere"))
					return 1;
				else
					return -1; // other = Papier
			case "Papier" :
				if (other.name.equals("Schere"))
					return -1;
				else
					return 1; // other = Stein
			}
		return 0;
	}
}
