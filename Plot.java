import java.awt.Point;

public class Plot {
	
	// Class Variables
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int depth = 0;
	private Point topLeft;
    	private Point bottomRight;
	
	// Basic constructor, no arguments
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
		}

	//Basic constructor, new object argument
	public Plot(Plot p) {
		this.x = p.getX();
		this.y = p.getY();
		this.width = p.getWidth();
		this.depth = p.getDepth();
		}

	//Basic constructor, X, Y, W, and D arguments
	public Plot(int X, int Y, int W, int D) {
		this.x = X;
		this.y = Y;
		this.width = W;
		this.depth = D;
		}

	//Get X coordinate
	public int getX()
	{ 
		return this.x; 
		}
	// Get Y coordinate
	public int getY()
	{ 
		return this.y; 
		}

	//Get Width
	public int getWidth()
	{ 
		return this.width;
		}

	// Get Depth
	public int getDepth()
	{ 
		return this.depth; 
		}

	// Set X
	public void setX(int X)
	{ 
		this.x = X; 
		}

	// Set Y
	public void setY(int Y)
	{ 
		this.y = Y; 
		}

	//Set Width
	public void setWidth(int W)
	{ 
		this.width = W; 
		}

	// Set Depth
	public void setDepth(int D)
	{ 
		this.depth = D;
		}

	//Check plot overlapping
	public boolean overlaps(Plot P) {
		
		// Variables
		int resultX = 0;
		int resultY = 0;

		if(this.topLeft != null && this.bottomRight != null) {
			//if this.topLeft.getX() are greater than P.bottomRight.getX() or this.bottomRight.getX() is less than P.topLeft.getX()
			if (this.topLeft.getX() > P.bottomRight.getX() || this.bottomRight.getX() < P.topLeft.getX()) {
				resultX = 1; //set resultX to 1
			}
			//if this.topLeft.getY() are greater than P.bottomRight.getX() or this.bottomRight.getX() is less than P.topLeft.getX()
			if (this.topLeft.getY() > P.bottomRight.getY() || this.bottomRight.getY() < P.topLeft.getY()) {
				resultX = 1; //set resultY to 1
			}
			//if this.topLeft.getY() is equal to P.topLeft.getY() or this.bottomRight.getY() is equal to P.bottomRight.getY()
			if (this.topLeft.getX() == P.topLeft.getX() || this.bottomRight.getX() == P.bottomRight.getX()) {
				resultX = 0; //set resultX to 0
			}
			//if this.topLeft.getY() is equal to P.topLeft.getY() or this.bottomRight.getY() is equal to P.bottomRight.getY()
			if (this.topLeft.getY() == P.topLeft.getY() || this.bottomRight.getY() == P.bottomRight.getY()) {
				resultY = 0; //set resultY to 0
			}
			if (resultX == 0 || resultY == 0) {
				return true;
			}
		}
	return false;
	}

	//Check plot container
	public boolean encompasses(Plot P) {
		// Variables
		int resultX = 0;
		int resultY = 0;
		int Px1 = P.getX(); // starting x coord (left) for Plot 
		int Tx1 = this.getX(); // starting x coord (left) for instance 
		int PWx2 = P.getX() + P.getWidth(); // ending x coord for Plot (right)
		int TWx2 = this.getX() + this.getWidth(); // ending x coord for instance(right)
		int Py3 = P.getY(); // starting y coord for Plot 
		int Ty3 = this.getY(); // starting y coord (top)
		int PDy4 = P.getY() + P.getDepth(); // ending y coord for Plot
		int TDy4 = this.getY() + this.getDepth(); // ending y coord (bottom)
		
		// Checks
		if (Px1 > Tx1 && PWx2 > TWx2) { 
			resultX = 1;
		}
		//Checks to see if y coord of plot 
		if (Py3 > Ty3 && PDy4 > TDy4) { 
			resultY = 1;
		}
		if (Px1 == Tx1 && PWx2 == TWx2 && Py3 == Ty3 && PDy4 == TDy4) { 
			return true;
		}
		if (resultX == 0 && resultY == 0) {
			return true;
		}
	return false;
	}

	// String method
	public String toString() {
		// Variables
		String s = "";

		//puts text lines into a string variable
		s += "Upper left: (" + this.getX() + "," + this.getY() + ")";
		s += " Width: " + this.getWidth();
		s += " Depth: " + this.getDepth();

		// Return
		return s;
	}
}