import java.util.*;

class PointSortingTestGenerator {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		int MAX_INT_RANGE = 10000;

		Random randGen = new Random();

		String[] inputFile = new String[n + 1];

		inputFile[0] = n + "";

		for (int i = 1; i < n + 1; i++) {
			int xSign = randGen.nextInt(2) < 1 ? -1 : 1;
			int ySign = randGen.nextInt(2) < 1 ? -1 : 1;
			inputFile[i] = xSign*randGen.nextInt(MAX_INT_RANGE) + " " + ySign*randGen.nextInt(MAX_INT_RANGE);
		}

		for (String s : inputFile) {
			System.out.println(s);
		}
	}
}
