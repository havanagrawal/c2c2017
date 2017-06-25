import java.io.*;
import java.util.*;

class BstArray {

	public static List<Integer> inOrder(int[] bst) {
		List<Integer> traversal = new ArrayList<>();

		inOrder(bst, 1, traversal);

		return traversal;
	}

	public static void inOrder(int[] bst, int current, List<Integer> traversal) {
		int n = bst.length;

		if (current < n && bst[current] != -1) {
			inOrder(bst, current*2, traversal);
			traversal.add(bst[current]);
			inOrder(bst, current*2 + 1, traversal);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");

		int n = s.length;

		int[] arr = new int[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(s[i]);
		}

		List<Integer> traversal = inOrder(arr);

		boolean isBst = true;

		for (int i = 0; i < traversal.size() - 1; i++) {
			if (traversal.get(i) > traversal.get(i + 1)) {
				isBst = false;
			}
		}

		if (isBst) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}
