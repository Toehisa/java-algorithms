public class Search<T extends Comparable<T>> {
    public T linearSearch(T[] arr, T target) {
        for(T item : arr) {
            if (item.equals(target)) return item;
        }
        return null;
    }
}
