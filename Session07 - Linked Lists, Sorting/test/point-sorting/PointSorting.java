import java.io.*;

class Point {
	/*DO NOT MODIFY ANYTHING IN THIS CLASS*/
	public final int x;
	public final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " " + y;
	}
}

class PointSorting {

	public static void sortPoints(Point[] points) {

		int n = points.length;

		double[] arr = new double[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Math.hypot(points[i].x, points[i].y);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

					Point tempPoint = points[j];
					points[j] = points[j + 1];
					points[j + 1] = tempPoint;
				}
			}
		}

		System.out.println(Arrays.toString(arr));

	}

	public static void main(String[] args) throws Exception {
		/*DO NOT MODIFY ANY OF THIS CODE*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			points[i] = new Point(x, y);
		}
		sortPoints(points);

		for (Point p : points) {
			System.out.println(p.toString());
		}
	}
}
