public class Sort<T extends Comparable<T>> {
    public void bubbleSort(T[] arr) {
        int size = arr.length - 1;
        boolean swaped;

        do {
            swaped = false;
            for (int i = 0; i < size; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;

                    swaped = true;
                }
            }
            size--;
        } while (swaped);
    }
}
