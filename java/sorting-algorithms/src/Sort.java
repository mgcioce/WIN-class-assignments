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
        Comparable temp;
        int min, max;
        if (ascending) {
            for (int i = 0; i < array.length; i++) {
                min = i;

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j].compareTo(array[min]) < 0) {
                        min = j;
                    }
                }
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                max = i;

                for (int j = i + 1; j < array.length; j++) {
                    if (array[j].compareTo(array[max]) > 0) {
                        max = j;
                    }
                }
                temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
    }

    /**
     * Insertion sort works by comparing array[k] and array[k-1]. if array[k] is less than
     * (or greater than in terms of descending sort) array[k-1], their values are flipped, and
     * array[k-1] is compared to array[k-2] until array[j] is greater than or equal to array[j-1] or
     * j == 0;
     * <p>
     * Parameters:
     *
     *      @param array - an array of objects whose class implements the Comparable interface
     *      @param ascending - a boolean value that represents whether to do ascending or descending
     *                       sorting
     * @return - void;
     */
    public static void insertionSort(Comparable[] array, boolean ascending) {
        Comparable temp = null;
        for (int i = 1; i < array.length; i++) {
            insertionSort(array,i,temp,ascending);
        }
    }

    /**
     * this is a recursive method that performs the comparison on the next set of
     * elements to be compared in the array. This performs the sorting of elements recursively, while
     * the first funciton acts as a bootstrapper function for each level of the sort.
     * <p>
     * Parameters:
     *
     *      @param array - the array of Comparable objects
     *      @param i - int value ofthe current index being compared to the index before it (i - 1)
     *      @param temp - Comparable variable meant to temporarily hold an object as places are
     *                  swapped
     * @return - void
     */
    private static void insertionSort(Comparable[] array, int i, Comparable temp, boolean ascending) {
        if (i == 0) {
            return;
        }
        if (ascending) {
            if (array[i].compareTo(array[i-1]) < 0) {
                temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
                insertionSort(array,i-1,temp,ascending);
            }
        } else {
            if (array[i].compareTo(array[i-1]) > 0) {
                temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
                insertionSort(array,i-1,temp,ascending);
            }
        }

    }

    public static void bubbleSort(Comparable[] array, boolean ascending) {
        boolean sorted = true;
        do {
            for (int i = 0; i < array.length - 1; i++) {
                sorted = true;
                if (ascending) {
                    if (array[i].compareTo(array[i+1]) > 0) {
                        sorted = false;
                        Comparable temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                    }
                } else {
                    if (array[i].compareTo(array[i+1]) < 0) {
                        sorted = false;
                        Comparable temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                    }
                }
            }
        } while(!sorted);
    }
}
