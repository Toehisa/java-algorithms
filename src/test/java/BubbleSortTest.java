import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void testStandardUnsortedArray() {
        Sort<Integer> sorter = new Sort<>();
        Integer[] arr = {5, 1, 4, 2, 8, -3};
        Integer[] expected = {-3, 1, 2, 4, 5, 8};

        sorter.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Массив должен быть отсортирован по возрастанию");
    }

    @Test
    void testAlreadySortedArray() {
        Sort<Integer> sorter = new Sort<>();
        Integer[] arr = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};

        sorter.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Отсортированный массив не должен измениться");
    }

    @Test
    void testReverseSortedArray() {
        Sort<Integer> sorter = new Sort<>();
        // Худший сценарий для пузырька
        Integer[] arr = {9, 7, 5, 3, 1};
        Integer[] expected = {1, 3, 5, 7, 9};

        sorter.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Массив в обратном порядке должен отсортироваться корректно");
    }

    @Test
    void testArrayWithDuplicates() {
        Sort<Integer> sorter = new Sort<>();
        Integer[] arr = {3, 1, 2, 3, 1, 5};
        Integer[] expected = {1, 1, 2, 3, 3, 5};

        sorter.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Дубликаты должны встать рядом друг с другом");
    }

    @Test
    void testEmptyAndSingleElementArrays() {
        Sort<Integer> sorter = new Sort<>();

        // Крайний случай 1: Пустой массив
        Integer[] emptyArr = {};
        sorter.bubbleSort(emptyArr);
        assertArrayEquals(new Integer[]{}, emptyArr, "Пустой массив не должен вызывать ошибок");

        // Крайний случай 2: Один элемент
        Integer[] singleArr = {42};
        sorter.bubbleSort(singleArr);
        assertArrayEquals(new Integer[]{42}, singleArr, "Массив из одного элемента не должен измениться");
    }

    @Test
    void testStringSortingGenerics() {
        // Проверяем, что твой дженерик <T extends Comparable<T>> реально работает для любых объектов
        Sort<String> sorter = new Sort<>();
        String[] arr = {"Яблоко", "Апельсин", "Банан", "Вишня"};

        // Лексикографическая (алфавитная) сортировка
        String[] expected = {"Апельсин", "Банан", "Вишня", "Яблоко"};

        sorter.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Строки должны отсортироваться по алфавиту");
    }
}
