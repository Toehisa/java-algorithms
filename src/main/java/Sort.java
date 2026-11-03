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

    public void quickSort(T[] arr) {
        if (arr == null || arr.length == 0) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int left, int right) {
        if (left >= right) return;//выход из рекурсии

        int mid = (left + right) >>> 1;
        T pivot = arr[mid];

        swapPivotAndLast(arr, mid, right);//Пивот в конец

        int pivotInsertionIdx = partition(arr, pivot, left, right);//свап элементов и получение индекса для пивота

        swapLastAndPivot(arr, right, pivotInsertionIdx);//Пивот в нужную позицию

        //рекурсия исключая сам пивот
        quickSort(arr, left, pivotInsertionIdx - 1);
        quickSort(arr, pivotInsertionIdx + 1, right);
    }

    private int partition(T[] arr, T pivot, int left, int right) {
        int i = left;
        int j = right - 1; // Начинаем перед спрятанным пивотом

        while (i <= j) {
            // Ищем слева элемент, который больше либо равен пивоту
            while (i <= j && arr[i].compareTo(pivot) < 0) {
                i++;
            }
            // Ищем справа элемент, который меньше либо равен пивоту
            while (i <= j && arr[j].compareTo(pivot) > 0) {
                j--;
            }

            // Если указатели не пересеклись — меняем элементы местами
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Указатель 'i' всегда остановится ровно там, куда нужно вставить пивот
        return i;
    }

    private void swap(T[] arr, int idx1, int idx2) {
        T buffer = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = buffer;
    }

    private void swapPivotAndLast(T[] arr, int idx1, int idx2) {
        swap(arr, idx1, idx2);
    }

    private void swapLastAndPivot(T[] arr, int idx1, int idx2) {
        swap(arr, idx1, idx2);
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
