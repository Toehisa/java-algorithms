import java.util.Arrays;

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

    public void mergeSort(T[] arr) {
        int length = arr.length;

        if (length < 2) {
            return;//выход из рекурсии когда остался 1 элемент
        }

        int mid = length / 2;
        //int mid = (low + high) >>> 1; или так

        T[] first = Arrays.copyOfRange(arr, 0, mid);//пилим на пополам
        mergeSort(first);//и отправляем в рекурсию

        T[] second = Arrays.copyOfRange(arr, mid, length);//пилим на пополам
        mergeSort(second);//и отправляем в рекурсию

        merge(arr, first, second);//Склеиваем куски в исходный массив
    }


    private void merge(T[] arr, T[] first, T[] second) {
        int i, j, k;
        i = j = k = 0;

        int fLength = first.length;
        int sLength = second.length;

        while (i < fLength && j < sLength) {
            if (first[i].compareTo(second[j]) <= 0) {
                arr[k++] = first[i++];
            } else {
                arr[k++] = second[j++];
            }
        }

        while (i < fLength) arr[k++] = first[i++];
        while (j < sLength) arr[k++] = second[j++];
    }


    private void insertAndShift(T[] arr, int left, int right) {
        T itemToInsert = arr[right];

        for (; right > left; right--) {
            arr[right] = arr[right - 1];
        }

        arr[left] = itemToInsert;
    }
}
