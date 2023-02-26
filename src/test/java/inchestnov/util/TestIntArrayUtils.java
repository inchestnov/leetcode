package inchestnov.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestIntArrayUtils {

    @Test
    void testIntArrayOf_nullParameter() {
        Assertions.assertThatThrownBy(() -> IntArrayUtils.intArrayOf((int[]) null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("must not be null");
    }

    @Test
    void testIntArrayOf_null() {
        int[] expected = {1, 2, 3};
        int[] actual = IntArrayUtils.intArrayOf(1, 2, 3);

        assertArrayEquals(expected, actual);
    }

}