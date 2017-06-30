/*
 * This example showcases what happens if you don't make your "immutable" class final
 * By using inheritance, one can "hack" into the class
 */

 // This class violates point 3 from
 // https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html

class Box {
	private int width;
	private int depth;
	private int height;

	public Box(int width, int depth, int height) {
		this.width = width;
		this.depth = depth;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getDepth() {
		return depth;
	}

	public int getHeight() {
		return height;
	}

	public int getVolume() {
		return width * height * depth;
	}

	@Override
	public String toString() {
		return "Box [w=" + width + ", h=" + height + ", d=" + depth + "]";
	}
}

class MutableBox extends Box {
	private int widthCopy;
	private int depthCopy;
	private int heightCopy;

	public MutableBox(int width, int depth, int height) {
		super(width, depth, height);
		this.widthCopy = width;
		this.depthCopy = depth;
		this.heightCopy = height;
	}

	public void setWidth(int width) {
		this.widthCopy = width;
	}

	public void setDepth(int depth) {
		this.depthCopy = depth;
	}

	public void setHeight(int height) {
		this.heightCopy = height;
	}

	@Override
	public int getWidth() {
		return widthCopy;
	}

	@Override
	public int getDepth() {
		return depthCopy;
	}

	@Override
	public int getHeight() {
		return heightCopy;
	}

	@Override
	public int getVolume() {
		return widthCopy * heightCopy * depthCopy;
	}
}

class BoxShipper {

	// Calling this method with the same Box instance _should_ be same by contract
	// Since any given Box is meant to be immutable
	public static double calculateShippingCost(Box b) {
		return 100.0 * b.getVolume();
	}

	public static void main(String[] args) {
		MutableBox b = new MutableBox(10, 10, 10);

		Box b2 = b;

		System.out.println(calculateShippingCost(b2));

		System.out.println(b);

		// cannot call setter methods on b2, because it is a Box reference
		// b2.setWidth(10);

		b.setWidth(20);

		System.out.println(b);

		System.out.println(calculateShippingCost(b2));
	}
}
