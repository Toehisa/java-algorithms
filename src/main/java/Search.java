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
        if (isEmpty(arr)) return null;

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

        //цикл закончился (left == right). Проверяем этот элемент!
        if (arr[left].equals(target)) {
            return arr[left];
        }
        return null;
    }

    //Поиск соседних элементов
    public T binarySearch3(T[] arr, T target) {
        if (isEmpty(arr)) return null;

        int right = arr.length - 1;
        int left = 0;

        while (left + 1 < right) {
            int mid = (left + right) >>> 1;

            if (arr[mid].compareTo(target) > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        //Оставшиеся два элемента
        if (arr[left].equals(target)) return arr[left];
        if (arr[right].equals(target)) return arr[right];
        return null;
    }

    private boolean isEmpty(T[] arr) {
        return arr == null || arr.length == 0;
    }
}
