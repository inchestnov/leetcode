package inchestnov.util;

import asserts.ArrayAssert;
import org.junit.jupiter.api.Test;

class TestArrayAssertions {

    @Test
    void test_hasPrefix() {
        int[] prefix = {1, 2, 3};
        int[] actual = {1, 2, 3, 4, 5};
        ArrayAssert.assertThat(actual).hasPrefix(prefix);
    }

    @Test
    void test_hasPrefixNull() {
        ArrayAssert.assertThat(null).hasPrefix(null);
    }

}