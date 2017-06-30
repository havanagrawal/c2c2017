class MergeSorter implements IntSorter {
    @Override
    public int[] sort(int[] arr) {
        int len = arr.length;

		if (len == 1) {
			return arr;
		}

		int[] arrCopy = new int[len];

		System.arraycopy(arr, 0, arrCopy, 0, len);

		/****************************
		*** Split into two halves ***
		*****************************/

		int mid = (int)(len/2);

		int[] left, right;
		left = new int[mid];
		right = new int[len - mid];

		System.arraycopy(arrCopy, 0, left, 0, mid);
		System.arraycopy(arrCopy, mid, right, 0, len - mid);

		/*****************************
		*** Recursively merge sort ***
		******************************/

		int[] leftSorted = sort(left);
		int[] rightSorted = sort(right);

		/**********************************
		*** Merge the two sorted halves ***
		***********************************/

		int[] sortedArr = merge(leftSorted, rightSorted);
		return sortedArr;
    }

	private int[] merge(final int[] leftSorted, final int[] rightSorted) {
		int len1 = leftSorted.length;
		int len2 = rightSorted.length;

		int[] merged = new int[len1 + len2];

		int i = 0, j = 0, k = 0;

        // Iterate till one of the arrays is not empty
		while (i < len1 && j < len2) {
			if (leftSorted[i] < rightSorted[j]) {
				merged[k] = leftSorted[i];
				i++;
			}
			else {
				merged[k] = rightSorted[j];
				j++;
			}
			k++;
		}

        // Empty out the leftSorted array into the merged array
		while (i < len1) {
			merged[k] = leftSorted[i];
			i++;
			k++;
		}

        // Empty out the rightSorted array into the merged array
		while (j < len2) {
			merged[k] = rightSorted[j];
			j++;
			k++;
		}

		return merged;
	}
}
