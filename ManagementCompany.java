
/**
 * Class: CMSC203 
 *  Program: Assignment #4
 *  Instructor: Professor Grinberg
 * Description: (Give a brief description for each Program)
   A program that requires you to encrypt and decrypt Text using two different ciphers.
 * Due: MM/DD/YYYY (<04/4/2022>)
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Bradley Hughes
*/

public class ManagementCompany {
	
	// Class Variables
	private int MAX_PROPERTY = 5;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private String name = "";
	private String taxID = "";
	private double mgmFeePer = 0;
	private Plot plot;
	private Property properties[] = new Property[MAX_PROPERTY];
	private int index = 0; //Starts the Property Index at 0
	
	private int maxRentPropertyIndex() {
		double maxRent = 0;
		int rentIndex = 0;
			
		//Loop
		for (int i = 0; ((i < properties.length) && (properties[i] !=null)); i++) {
			// Variables
			if(maxRent < properties[i].getRentAmount()) {
				maxRent = properties[i].getRentAmount();
				rentIndex = i;
			}
		}
		return rentIndex;
	}
	
	private String displayPropertyAtIndex(int i) {
		
		return "\n" + this.properties[i].toString();
	}
	
	//Constructor without parameters sets plot to defaults values
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		Property properties[] = new Property [MAX_PROPERTY];
	}

	//Constructor creates a ManagementCompany object using passed information and sets plot to defaults values
	public ManagementCompany(String n, String tax, double mfee) {
		this.name = n;
		this.taxID = tax;
		this.mgmFeePer = mfee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		Property properties[] = new Property [MAX_PROPERTY];
	}

	//Constructor creates a ManagementCompany object using passed information and sets plot to passed information
	public ManagementCompany(String n, String tax, double mfee, int x, int y, int w, int d) {
		this.name = n;
		this.taxID = tax;
		this.mgmFeePer = mfee;
		this.plot = new Plot(x, y, w, d);
		Property properties[] = new Property [MAX_PROPERTY];
	}
	
	//Constructor is copied and creates a ManagementCompany object from another ManagementCompany object
	public ManagementCompany(ManagementCompany otherCompany) {
		this.MAX_PROPERTY = otherCompany.getMAX_PROPERTY();
		this.MGMT_WIDTH = otherCompany.MGMT_WIDTH;
		this.MGMT_DEPTH = otherCompany.MGMT_DEPTH;
		this.name = otherCompany.getName();
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.getPlot();
		this.properties = otherCompany.properties;
	}
		
	//Add property (Property)
	public int addProperty(Property property) {
		
		int rtn = 0;
		
		//Checks to see if array is full
		if (index >= MAX_PROPERTY) {
			rtn = -1; 
		}
		else if  (property == null) {
			rtn = -2; //property is null
		}
		else if (!plot.encompasses(property.getPlot()))	{
			rtn = -3; //mgmtCo plot does not encompass property plot
		}
		else {
			for (int i=0; i < properties.length; i++) {
				if (properties[i] == null) {
					//create a new property to avoid information change 
					Property p =  new Property (property);
					properties[i] = p;
					rtn = i;
					break;
				}
				else {
					if (!properties[i].getPlot().overlaps(property.getPlot())) {
						rtn = -4;  //if property plot overlaps ANY of properties in array, return -4
						//break;
					}
				}
			}
		}
		return rtn;
	}

	//Add property (Name, City, Rent, Owner)
	public int addProperty(String name, String city, double rent, String owner) {
		
		Plot manPlot = new Plot(); 
		int rtn = -1;
		Property manProperty = new Property(name,city,rent,owner);
		if (index >= MAX_PROPERTY) {
			rtn = -1; //set rtn to -1
		}
		else if (properties == null) { 
			rtn = -2; //set rtn to -2
		}
		else if (manProperty.getPlot().encompasses(manPlot) == false) {  
			rtn = -3; //set rtn to -3
		}
		for (int i = 0; i < index; i++) {
			// Checks
			if(properties[i] != null) {
				if (properties[i].getPlot().overlaps(manPlot) == true) {
					rtn = -4; //set rtn to -4
				}
			}
		}
		index++;
		rtn = index;
		// Default
		return rtn;
	}

	// Add property (Name, City, Rent, Owner, X, Y, Width, Depth)
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int w, int d) {
		
		Plot manPlot = new Plot(x,y,w,d); 
		int rtn = 0; //Set rtn to 0
		Property manProperty = new Property(name,city,rent,owner);
		if (index >= MAX_PROPERTY) {
			rtn = -1; //Set rtn to -1
		}
		else if (manProperty.getPlot().encompasses(manPlot) == false) {  
			rtn = -3; //Set rtn to -3
		}
		for (int i = 0; i < index; i++) {
			//Checks to see if property is null
			if(properties[index] != null) {
				if (properties[i].getPlot().overlaps(manPlot) == true) {
					rtn = -4; //set rtn to -4
				}
			}
		}
		if (properties == null) { 
			rtn = -2; //Set rtn to -2
		}
		
		index++;
		rtn = index;
		// Default
		return rtn;
	}

	//Returns the max amount of properties allowed
	public int getMAX_PROPERTY() {
		return this.MAX_PROPERTY;
	}

	//Returns the management property plot
	public Plot getPlot() {
		return this.plot;
	}

	//Returns the management company name
	public String getName() { 
		return this.name; 
	}

	//Returns the total rent due
	public double totalRent() {
		//Variable of total
		double total = 0;
		
		for (int index = 0; index < properties.length; index++) {
			if(properties[index] != null) {
				total += properties[index].getRentAmount();
			}
		}
		return total;
	}

	//Returns the string version of Properties object
	public String toString() {
		//Sets up String Variable
		String s = "";
		
		//Puts text lines into string variable
		s += "List of the properties for " + this.getName() + ", TaxID: " + this.taxID;
		
		s+= "\n ______________________________________________________\n";

		// Loop
		for (int i = 0; i < 5; i++) {
			
			Property p = this.properties[i];
			
			if (p == null) {
				continue; 
			}
			
			s += displayPropertyAtIndex(i);
			}
		
		s += "\n______________________________________________________\n";
		
		// Append
		s += "\ntotal management Fee: " + (this.totalRent() * (this.mgmFeePer * 0.01));
		
		// Return
		return s;
	}
}
