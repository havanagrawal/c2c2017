import java.io.*;

class SelectionSorterTest {

	public static int[] selectionSortStepper(int[] arr) {
		int len = arr.length;
		int[] arrCopy = new int[len];

		System.arraycopy(arr, 0, arrCopy, 0, len);

		int j = 0;

		while (j < len) {
			int min = Integer.MAX_VALUE;
			int index_of_min = -1;

			// Find the minimum
			// We start from j because the first j-1 elements must be sorted by this point
			for (int i = j; i < len; i++) {
				if (arrCopy[i] < min) {
					min = arrCopy[i];
					index_of_min = i;
				}
			}

			// Place it at its position
			arrCopy[index_of_min] = arrCopy[j];
			arrCopy[j] = min;
			j++;
			printArray(arrCopy);
		}

		return arrCopy;
	}

	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int[] arr = new int[s.length];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}

		selectionSortStepper(arr);
	}
}
