import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MergeSortTest {

    private Sort<Integer> intSorter;
    private Sort<String> stringSorter;

    @BeforeEach
    void setUp() {
        intSorter = new Sort<>();
        stringSorter = new Sort<>();
    }

    @Test
    void testEmptyArray() {
        Integer[] arr = {};
        intSorter.mergeSort(arr);
        assertArrayEquals(new Integer[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        Integer[] arr = {42};
        intSorter.mergeSort(arr);
        assertArrayEquals(new Integer[]{42}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        intSorter.mergeSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr);
    }

    @Test
    void testReverseSortedArray() {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        intSorter.mergeSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr);
    }

    @Test
    void testUnsortedArrayWithDuplicates() {
        // Проверка устойчивости и правильной обработки дубликатов
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        intSorter.mergeSort(arr);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    void testNegativeNumbers() {
        Integer[] arr = {-5, 2, -1, 0, 3, -10, 7};
        intSorter.mergeSort(arr);
        assertArrayEquals(new Integer[]{-10, -5, -1, 0, 2, 3, 7}, arr);
    }

    @Test
    void testStringArray() {
        // Проверка работы дженериков (Comparable)
        String[] arr = {"kiwi", "apple", "mango", "banana", "cherry"};
        stringSorter.mergeSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "cherry", "kiwi", "mango"}, arr);
    }

    @Test
    void testLargeArray() {
        // Проверяем, что рекурсия не падает на чуть более крупных данных
        Integer[] arr = new Integer[1000];
        Integer[] expected = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 1000 - i;       // Заполняем в обратном порядке
            expected[i] = i + 1;     // Ожидаемый прямой порядок
        }

        intSorter.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testNullArrayThrowsException() {
        // В твоем коде первая строка int length = arr.length;
        // Поэтому при null мы ожидаем стандартный NullPointerException
        assertThrows(NullPointerException.class, () -> {
            intSorter.mergeSort(null);
        });
    }
}