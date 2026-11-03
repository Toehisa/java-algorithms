import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class QuickSortTest {

    private Sort<Integer> intSorter;
    private Sort<String> stringSorter;

    @BeforeEach
    void setUp() {
        intSorter = new Sort<>();
        stringSorter = new Sort<>();
    }

    @Test
    void testNullArrayDoesNotThrowException() {
        assertDoesNotThrow(() -> intSorter.quickSort(null));
    }

    @Test
    void testEmptyArray() {
        Integer[] arr = {};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        Integer[] arr = {42};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{42}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr);
    }

    @Test
    void testReverseSortedArray() {
        Integer[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, arr);
    }

    @Test
    void testUnsortedArrayWithDuplicates() {
        // Важнейший тест для Quick Sort. Именно здесь зависают
        // плохие реализации из-за неправильной обработки равных элементов.
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    void testArrayWithAllSameElements() {
        // Еще один стресс-тест для partition
        Integer[] arr = {7, 7, 7, 7, 7, 7};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{7, 7, 7, 7, 7, 7}, arr);
    }

    @Test
    void testNegativeNumbers() {
        Integer[] arr = {-5, 2, -1, 0, 3, -10, 7};
        intSorter.quickSort(arr);
        assertArrayEquals(new Integer[]{-10, -5, -1, 0, 2, 3, 7}, arr);
    }

    @Test
    void testStringArray() {
        String[] arr = {"zebra", "apple", "mango", "banana", "cherry"};
        stringSorter.quickSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "cherry", "mango", "zebra"}, arr);
    }

    @Test
    void testLargeArray() {
        // Проверяем, что алгоритм не падает со StackOverflow на средних объемах
        Integer[] arr = new Integer[10000];
        Integer[] expected = new Integer[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = 10000 - i;       // Заполняем в обратном порядке
            expected[i] = i + 1;      // Ожидаемый прямой порядок
        }

        intSorter.quickSort(arr);
        assertArrayEquals(expected, arr);
    }
}