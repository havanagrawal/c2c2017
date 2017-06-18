import java.util.*;

class SelectionSortTestGenerator {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		Random randGen = new Random();

		for (int i = 0; i < n; i++) {
			System.out.print(randGen.nextInt() + " ");
		}
		System.out.println();
	}
}
