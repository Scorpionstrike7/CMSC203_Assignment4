
public class Property {
	// Class Variables
	private String propertyName = "";
	private String city = "";
	private String owner = "";
	private double rentAmount = 0;
	private Plot plot;
	
	//Basic constructor, no arguments
	public Property() {
		String propertyName = "";
		String city = "";
		String owner = "";
		double rentAmount = 0;
		this.plot = new Plot();
	}
	
	//Constructor to duplicate a property
	public Property(Property p) {
		this.propertyName = p.getPropertyName();
		this.city = p.getCity();
		this.rentAmount = p.getRentAmount();
		this.owner = p.getOwner();
		this.plot = p.getPlot();
	}
	
	//Constructor with Name, City, Rent, Owner
	public Property(String N, String C, double R, String O) {
		this.propertyName = N;
		this.city = C;
		this.rentAmount = R;
		this.owner = O;
		this.plot = new Plot();
	}
	
	//Constructor with Name, City, Rent, Owner, X, Y, Width, Depth
	public Property(String N, String C, double R, String O, int X, int Y, int W, int D) {
		this.propertyName = N;
		this.city = C;
		this.rentAmount = R;
		this.owner = O;
		this.plot = new Plot(X, Y, W, D);
	}
	
	//Get property city
	public String getCity() { 
		return this.city; 
	}
		
	//Get property owner
	public String getOwner() { 
		return this.owner; 
	}

	//Get property plot
	public Plot getPlot() { 
		return this.plot; 
	}
		
	//Get property name
	public String getPropertyName(){
		return propertyName; 
	}

	//Get property rent
	public double getRentAmount() { 
		return this.rentAmount; 
	}
	
	//Get property plot
	public Plot setPlot(int X, int Y, int Width, int Depth) { 
		int x = X;
		int y = Y;
		int width = Width;
		int depth = Depth;
		return this.plot; 
	}

	//Set property city
	public void setCity(String S) {
		this.city = S; 
	}

	//Set property owner
	public void setOwner(String O) { 
		this.owner = O; 
	}

	//Set property name
	public void setPropertyName(String N)
	{
		this.propertyName = N;
		}

	//Set property rent amount
	public void setRentAmount(double R) {
		this.rentAmount = R;
	}

	//Create a String to print text
	public String toString() {
		// Variables
		String r = "";

		//Adds text lines to r variable
		r += "Property Name: " + this.getPropertyName();
		r += "\n" + "Located in " + this.getCity();
		r += "\n" + "Belonging to: " + this.getOwner();
		r += "\n" + "Rent Amount: " + this.getRentAmount();
		r += " ";

		// Return string variable
		return r;
	}
}