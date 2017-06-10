import java.util.Random;

class IntSorterTimer {

	public static void main(String args[]) {

		String[] sortNames = {"bubbleSort", "selectionSort", "insertionSort", "mergeSort"};
		long[] sortTimes = new long[sortNames.length];

		System.out.print("Sort name/n\t");
		for (String sortName : sortNames) {
			System.out.print(sortName + "\t");
		}
		System.out.println();

		for (int i = 1; i < 1000_000; i *= 10) {
			sortTimes[0] = timer(new BubbleSorter(), i);
			sortTimes[1] = timer(new SelectionSorter(), i);
			sortTimes[2] = timer(new InsertionSorter(), i);
			sortTimes[3] = timer(new MergeSorter(), i);

			System.out.print(i + "\t\t");
			for (long sortTime : sortTimes) {
				System.out.print(sortTime + "\t\t");
			}
			System.out.println();
		}
	}

	public static long timer(IntSorter sorter, int n) {
		Random randomGen = new Random();
		final int MAX = Integer.MAX_VALUE;
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = randomGen.nextInt(MAX);
		}

		long startTime = System.currentTimeMillis();
		int[] sortedArr = sorter.sort(arr);
		long endTime = System.currentTimeMillis();

		long timeTakenInMilliseconds = endTime - startTime;

		for (int i = 0; i < arr.length - 1; i++) {
			if (sortedArr[i] > sortedArr[i + 1]) {
				throw new RuntimeException("Your implementation for " + sorter.getClass() + " is faulty!");
			}
		}

		return timeTakenInMilliseconds;
	}
}
