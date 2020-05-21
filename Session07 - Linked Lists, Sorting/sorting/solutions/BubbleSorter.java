class BubbleSorter implements IntSorter {

    @Override
    public int[] sort(int[] arr) {
        int len = arr.length;
        int[] arrCopy = new int[len];

        System.arraycopy(arr, 0, arrCopy, 0, len);

        // Requires n iterations
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                // Swap adjacent elements if they are out of order
                if (arrCopy[j] > arrCopy[j + 1]) {
                    int t = arrCopy[j];
                    arrCopy[j] = arrCopy[j + 1];
                    arrCopy[j + 1] = t;
                }
            }
        }

        return arrCopy;
    }
}
