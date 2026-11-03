import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InsertSortTest {

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
        intSorter.insertSort(arr);
        assertArrayEquals(new Integer[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        Integer[] arr = {42};
        intSorter.insertSort(arr);
        assertArrayEquals(new Integer[]{42}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        intSorter.insertSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSortedArray() {
        Integer[] arr = {5, 4, 3, 2, 1};
        intSorter.insertSort(arr);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testUnsortedArrayWithDuplicates() {
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        intSorter.insertSort(arr);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 4, 5, 5, 6, 9}, arr);
    }

    @Test
    void testNegativeNumbers() {
        Integer[] arr = {-5, 2, -1, 0, 3, -10};
        intSorter.insertSort(arr);
        assertArrayEquals(new Integer[]{-10, -5, -1, 0, 2, 3}, arr);
    }

    @Test
    void testStringArray() {
        String[] arr = {"banana", "apple", "cherry", "date"};
        stringSorter.insertSort(arr);
        assertArrayEquals(new String[]{"apple", "banana", "cherry", "date"}, arr);
    }

    @Test
    void testNullArrayThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            intSorter.insertSort(null);
        });
    }
}