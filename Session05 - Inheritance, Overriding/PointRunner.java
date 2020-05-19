class Point {
	private int x;
	
	// public so that anyone can instantiate an instance of Point
	public Point(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
}

// Since we already have a class that handles the x dimension
// We extend it, so that this class is only responsible for the y dimension
// This also makes sense because it is perfectly valid to say that a 2D Point is a Point
class Point2D extends Point {
	private int y;
	
	// public so that anyone can instantiate an instance of 2DPoint
	public Point2D(int x, int y) {
		// super calls the constructor of the superclass
		// We do this because we don't have access on x directly
		super(x);
		this.y = y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	// Remember that the methods getX and setX have been inherited
}

class PointRunner {
	public static void main(String[] args) {		
		Point2D p2 = new Point2D(10, 20);
		System.out.println("p2.getX(): " + p2.getX());
		System.out.println("Calling p2.setX(30)");
		p2.setX(30);
		System.out.println("p2.getX(): " + p2.getX());
	}
}