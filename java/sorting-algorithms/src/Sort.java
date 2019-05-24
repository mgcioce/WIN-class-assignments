public class Sort {
    /**
     * Selection sort works by selecting the smallest (or largest) value in the array
     * and putting it at index 0 in the array. It then searches for the next smallest
     * ( or largest) value to be at index 1, and so on until the array is sorted;
     * <p>
     * Parameters:
     *
     *      @param array - an array of generic objects to be sorted.
     *      @param ascending - boolean variable: true means the array will be
     *                       sorted in ascending order; will sort in descending order;
     * @return - void;
     */

    public static void selectionSort(Comparable [] array, boolean ascending) {
        Comparable min, max;
        if (ascending) {
            for (int i = 0; i < array.length; i++) {
                min = array[i];

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j].compareTo(min) < 0) {
                        min = array[j];
                    }
                }
                array[i] = min;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                max = array[i];

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j].compareTo(max) > 0) {
                        max = array[j];
                    }
                }
                array[i] = max;
            }
        }
    }
}
