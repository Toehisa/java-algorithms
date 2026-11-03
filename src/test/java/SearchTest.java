import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    private Search<Integer> intSearch;
    private Search<User> userSearch;

    @BeforeEach
    void setUp() {
        intSearch = new Search<>();
        userSearch = new Search<>();
    }

    // --- ТЕСТЫ ДЛЯ LINEAR SEARCH ---
    @Test
    void testLinearSearch() {
        Integer[] arr = {10, 20, 30, 40, 50};
        assertEquals(30, intSearch.linearSearch(arr, 30));
        assertNull(intSearch.linearSearch(arr, 100)); // Не найдено
        assertNull(intSearch.linearSearch(new Integer[]{}, 10)); // Пустой массив
    }

    // --- ТЕСТЫ ДЛЯ BINARY SEARCH 1 (Точный поиск) ---
    @Test
    void testBinarySearch() {
        Integer[] arr = {10, 20, 30, 40, 50}; // Массив должен быть отсортирован!

        assertEquals(10, intSearch.binarySearch(arr, 10)); // Начало
        assertEquals(30, intSearch.binarySearch(arr, 30)); // Середина
        assertEquals(50, intSearch.binarySearch(arr, 50)); // Конец

        assertNull(intSearch.binarySearch(arr, 25)); // Не найдено
        assertNull(intSearch.binarySearch(new Integer[]{}, 10)); // Пустой массив
    }

    // --- ТЕСТЫ ДЛЯ BINARY SEARCH 2 (Поиск первого вхождения) ---
    @Test
    void testBinarySearch2_FirstOccurrence() {
        // Создаем массив пользователей с одинаковым ID = 1
        User user1 = new User(1, "Alice");
        User user2 = new User(1, "Bob");
        User user3 = new User(2, "Charlie");
        User[] users = {user1, user2, user3};

        // Ищем пользователя с ID = 1. 
        // Метод должен вернуть ИМЕННО первого (Alice), а не Bob.
        User target = new User(1, "Target");
        User found = userSearch.binarySearch2(users, target);

        assertNotNull(found);
        assertEquals("Alice", found.name); // Проверяем, что это первое вхождение

        assertNull(intSearch.binarySearch2(new Integer[]{}, 10)); // Пустой массив
    }

    // --- ТЕСТЫ ДЛЯ BINARY SEARCH 3 (Поиск соседних элементов) ---
    @Test
    void testBinarySearch3() {
        Integer[] arr = {10, 20, 30, 40, 50};

        assertEquals(10, intSearch.binarySearch3(arr, 10)); // Начало
        assertEquals(40, intSearch.binarySearch3(arr, 40)); // Ближе к концу

        assertNull(intSearch.binarySearch3(arr, 99)); // Не найдено
        // Пустой массив (ожидаем, что метод вернет null и не упадет с ошибкой)
        assertNull(intSearch.binarySearch3(new Integer[]{}, 10));
    }

    // Вспомогательный класс для проверки "первого вхождения"
    static class User implements Comparable<User> {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        // Сравниваем ТОЛЬКО по ID
        @Override
        public int compareTo(User o) {
            return Integer.compare(this.id, o.id);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof User)) return false;
            return this.id == ((User) obj).id;
        }
    }
}