package inchestnov.util;

import org.junit.jupiter.api.Test;

class TestArrayAssertions {

    @Test
    void test_assert() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3, 4, 5};
        ArrayAssertions.assertArrayPrefixEquals(expected, actual);
    }

    @Test
    void test_assertNull() {
        ArrayAssertions.assertArrayPrefixEquals(null, null);
    }

}