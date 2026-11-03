public class Search<T extends Comparable<T>> {
    public T linearSearch(T[] arr, T target) {
        for(T item : arr) {
            if (item.equals(target)) return item;
        }
        return null;
    }


    //Точный поиск элемента
    public T binarySearch(T[] arr, T target) {
        int right = arr.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (arr[mid].compareTo(target) > 0) {
                right = mid - 1;
            } else if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                return arr[mid];
            }
        }

        return null;
    }

    //Поиск границы (Первое вхождение)
    public T binarySearch2(T[] arr, T target) {
        int right = arr.length - 1;
        int left = 0;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (arr[mid].compareTo(target) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }

    //Поиск соседних элементов
    public T binarySearch3(T[] arr, T target) {
        int left = 0, right = arr.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid].compareTo(target) > 0) {
                right = mid; // Сужаем прямо до mid
            } else {
                left = mid;  // Сужаем прямо до mid
            }
        }
        //Оставшиеся два элемента
        if (arr[left].equals(target)) return arr[left];
        if (arr[right].equals(target)) return arr[right];
        return null;
    }
}
