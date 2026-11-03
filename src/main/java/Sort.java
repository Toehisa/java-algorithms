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

    public void insertSort(T[] arr) {
        if (arr == null || arr.length < 2) return;

        var length = arr.length;

        for (int sorted = 0, unsorted = 1; unsorted < length;) {
            if (arr[sorted].compareTo(arr[unsorted]) > 0) {
                insertAndShift(arr, sorted, unsorted);
                unsorted++;
                sorted = 0;
            } else {
                sorted++;
            }

            if (sorted == unsorted) {
                sorted = 0;
                unsorted++;
            }
        }
    }

    private void insertAndShift(T[] arr, int left, int right) {
        T itemToInsert = arr[right];

        for (; right > left; right--) {
            arr[right] = arr[right - 1];
        }

        arr[left] = itemToInsert;
    }
}
